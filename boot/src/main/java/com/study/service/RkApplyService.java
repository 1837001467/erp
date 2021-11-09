package com.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.entity.*;
import com.study.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2021-11-06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RkApplyService{
        @Autowired
    RkApplyMapper   rkApplyMapper;
        @Autowired
    KcStockMapper   kcStockMapper;
        @Autowired
    CcStockMapper   ccStockMapper;
        @Autowired
    CgStorageMapper storageMapper;
    @Autowired
    CgReturnMapper cgReturnMapper;

    public PageInfo<RkApply> selectByPager(Integer no, Integer size){
        PageHelper.startPage(no,size);/*开启分页模式*/
        List<RkApply> list = rkApplyMapper.selectAll();/*调用mapper的查询方法*/
        return new PageInfo(list);/*将查询结果封装到PageInfo对象中并返回*/
    }

    public   Integer   cgAdd(String stCode){
        //1.查询到订单详情
        CgStorage cgStorage = rkApplyMapper.selectBystCode(stCode);
        List<CgStorageDetail> list  = rkApplyMapper.selectBystId(cgStorage.getStId());
        //2.生成入库申请
        RkApply rkApply = new RkApply();
        rkApply.setRkBian(this.automatic("rk"));
        rkApply.setStCode(stCode);
        rkApply.setYhShen(cgStorage.getQxUser());
        rkApply.setRkApplicationtime(new Timestamp(System.currentTimeMillis()));
        rkApply.setRkType("采购入库");
        rkApply.setRkState(0);
      Integer id = rkApplyMapper.cgAdd(rkApply);
        //3.生成入库申请详情
        for (CgStorageDetail cgStorageDetail : list) {
            RkDetails  rkDetails  = new RkDetails();
            rkDetails.setRkId(rkApply.getRkId());
            rkDetails.setRkdNum(cgStorageDetail.getSdCount());
            rkDetails.setGood(cgStorageDetail.getGoods());
            rkApplyMapper.addDetails(rkDetails);
        }
        return id;
    }

    public  Integer  update(Integer  rkId,Integer rkState){
        Integer  state = rkApplyMapper.update(rkId,rkState);
        return  state;
    }

    public  List<RkApply> lookDetails(Integer rkId){
        return rkApplyMapper.selectById(rkId);
    }

    public Integer  updateState(Integer rkId,String stCode,Integer rkState,Integer  yhId){
        CgStorage cgStorage = rkApplyMapper.selectBystCode(stCode);
        List<CgStorageDetail> list  = rkApplyMapper.selectBystId(cgStorage.getStId());
       Integer state = rkApplyMapper.update(rkId,rkState);  //修改入库申请的状态
        this.adopt(rkId,yhId,new Timestamp(System.currentTimeMillis()),stCode);//添加入库申请和采购入库的审批人
        rkApplyMapper.updateTwo(stCode,rkState+1); //修改采购入库的状态
        if(rkState == 1){
            //成功的情况
            //1.生成一条或则多条库存变动记录
            for (CgStorageDetail cgStorageDetail : list) {
                KcStock  kcStock =new KcStock();
                kcStock.setKcNum(cgStorageDetail.getSdCount());
                kcStock.setKcType("采购入库");
                kcStock.setWh(cgStorage.getCk());
                kcStock.setUser(cgStorage.getSppeo());
                kcStock.setGoods(cgStorageDetail.getGoods());
                kcStock.setKcTime(new Timestamp(System.currentTimeMillis()));
                kcStock.setKcBian(this.automatic("kc"));
                kcStockMapper.change(kcStock);
            }
            //2.增加库存
            for (CgStorageDetail cgStorageDetail : list) {
                CcStock ccStock = ccStockMapper.selectByWidAndGid(cgStorage.getCk().getWhId(),cgStorageDetail.getGoods().getGoId());
                ccStock.setCcNum(ccStock.getCcNum()+cgStorageDetail.getSdCount());
                ccStockMapper.updateNum(ccStock.getCcId(),ccStock.getCcNum());
            }
            return state;
        }else{
            //不通过的情况
            //退货(入库不通过，进入退货)//新增
            Timestamp nowtime= new Timestamp(System.currentTimeMillis());
            //入库单
            CgStorage rk=storageMapper.selectByCode(stCode);
            System.out.println("rk="+rk);
            JcSupplier supplier=rk.getJcSupplier();//供应商
            QxUser user=rk.getQxUser();//采购员
            JcWhinformation ck=rk.getCk();//仓库
            //生成退货编码
            Calendar now = Calendar.getInstance();
            String year = String.valueOf(now.get(Calendar.YEAR));
            String month = String.valueOf(now.get(Calendar.MONTH)+1);
            String day = String.valueOf(now.get(Calendar.DAY_OF_MONTH));
            String num = String.valueOf((int)((Math.random()*9+1)*1000));
            String proceedsYard = "THD"+year+month+day+num;

            CgReturn cgReturn=new CgReturn(null,proceedsYard,nowtime,"入库失败，商品有质量问题",null,null,0);
            cgReturn.setSupplier(supplier);
            cgReturn.setUser(user);
            cgReturn.setCk(ck);
            return cgReturnMapper.addTh(cgReturn);

        }
    }

    public  Integer  adopt(Integer rkId,Integer yhId,Timestamp time,String stCode){
        rkApplyMapper.adoptTwo(yhId, time, stCode);
        return rkApplyMapper.adopt(yhId, time, rkId);
    }

    //自动生成编号
    public   String  automatic(String head){
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String date = f.format(new Date());
        List<RkApply> list = rkApplyMapper.selectAll(); // 调用Service中的方法获取SQL中的数据
        if(list.size() > 0){
            String n = list.get(0).getRkBian();
            int intNumber = Integer.parseInt(n.substring(10));
            intNumber++;
            String Number = String.valueOf(intNumber);
            for (int i = 0; i < 3; i++){
                Number = Number.length() < 3 ? "0" + Number : Number;
            }
            return (head + date + Number);
        }else{
            return ( head + date + "001");
        }
    }
}
