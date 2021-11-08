package com.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.entity.*;
import com.study.mapper.RkApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
        rkApply.setRkBian(this.automatic());
        rkApply.setStCode(stCode);
        rkApply.setYhShen(cgStorage.getQxUser());
        rkApply.setRkApplicationtime(new Timestamp(System.currentTimeMillis()));
        rkApply.setRkType("采购入库");
        rkApply.setRkState(0);
        rkApplyMapper.cgAdd(rkApply);
        //3.生成入库申请详情
        for (CgStorageDetail cgStorageDetail : list) {
            RkDetails  rkDetails  = new RkDetails();
            rkDetails.setRkId(rkApply.getRkId());
            rkDetails.setRkdNum(cgStorageDetail.getSdCount());
            rkDetails.setGood(cgStorageDetail.getGoods());
            rkApplyMapper.addDetails(rkDetails);
        }
        return  1;
    }

    public  Integer  update(Integer  rkId,Integer rkState){
        Integer  state = rkApplyMapper.update(rkId,rkState);
        if(state !=1){
            return 0;
        }
        return  state;
    }

    public  List<RkApply> lookDetails(Integer rkId){
        return rkApplyMapper.selectById(rkId);
    }

    public Integer  updateState(Integer rkId,String stCode,Integer rkState,Integer  yhId){
        rkApplyMapper.update(rkId,rkState);  //修改入库申请的状态
        this.adopt(rkId,yhId,new Timestamp(System.currentTimeMillis()),stCode);//添加入库申请和采购入库的审批人
        rkApplyMapper.updateTwo(stCode,rkState+1); //修改采购入库的状态
//        if(rkState == 1){
//            //成功的情况
//
//        }else{
//            //不通过的情况
//
//        }
        return 0;
    }

    public  Integer  adopt(Integer rkId,Integer yhId,Timestamp time,String stCode){
        rkApplyMapper.adoptTwo(yhId, time, stCode);
        return rkApplyMapper.adopt(yhId, time, rkId);
    }

    //自动生成编号
    public   String  automatic(){
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
            return ("rk" + date + Number);
        }else{
            return ( "rk" + date + "001");
        }
    }
}
