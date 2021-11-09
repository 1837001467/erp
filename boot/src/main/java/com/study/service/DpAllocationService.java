package com.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.entity.*;
import com.study.mapper.CcStockMapper;
import com.study.mapper.DpAllocationMapper;
import com.study.mapper.KcStockMapper;
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
public class DpAllocationService{
    @Autowired
    DpAllocationMapper dpAllocationMapper ;
    @Autowired
    KcStockMapper kcStockMapper;
    @Autowired
    CcStockMapper ccStockMapper;
    public PageInfo<DpAllocation> selectByPager(Integer pageNO, Integer pageSize) {
        PageHelper.startPage(pageNO,pageSize);/*开启分页模式*/
        List<DpAllocation> list = dpAllocationMapper.selectPager();/*调用mapper的查询方法*/
        return new PageInfo(list);/*将查询结果封装到PageInfo对象中并返回*/
    }

    public Integer updateState(String dpBian, Integer rkState,Integer yhId) {
        DpAllocation dpAllocation = dpAllocationMapper.selectBydpBian(dpBian);
       Integer State = dpAllocationMapper.UpdateBydpBian(dpBian, rkState);
        this.adopt(yhId,new Timestamp(System.currentTimeMillis()),dpBian);
        QxUser  qxUser = new QxUser();
        qxUser.setYhId(yhId);
        //新增出入库库存变动
        if(rkState ==1){
            //审核通过
            //一条出库记录
            KcStock  outStock =new KcStock();
            outStock.setKcNum(dpAllocation.getDpNum());
            outStock.setKcType("调拨出库");
            outStock.setWh(dpAllocation.getWhOut());
            outStock.setUser(qxUser);
            outStock.setGoods(dpAllocation.getgId());
            outStock.setKcTime(new Timestamp(System.currentTimeMillis()));
            outStock.setKcBian(this.automatic("kc"));
           Integer id = kcStockMapper.change(outStock);
            //一条入库记录
            KcStock  inStock =new KcStock();
            inStock.setKcNum(dpAllocation.getDpNum());
            inStock.setKcType("调拨入库");
            inStock.setWh(dpAllocation.getWhIn());
            inStock.setUser(qxUser);
            inStock.setGoods(dpAllocation.getgId());
            inStock.setKcTime(new Timestamp(System.currentTimeMillis()));
            inStock.setKcBian(this.automatic("kc"));
            kcStockMapper.change(inStock);
            //减少库存
            CcStock ccOutStock = ccStockMapper.selectByWidAndGid(dpAllocation.getWhOut().getWhId(),dpAllocation.getgId().getGoId());
            ccOutStock.setCcNum(ccOutStock.getCcNum()-dpAllocation.getDpNum());
            ccStockMapper.updateNum(ccOutStock.getCcId(),ccOutStock.getCcNum());
            //增加库存
            CcStock ccInStock = ccStockMapper.selectByWidAndGid(dpAllocation.getWhIn().getWhId(),dpAllocation.getgId().getGoId());
            ccInStock.setCcNum(ccInStock.getCcNum()+dpAllocation.getDpNum());
            ccStockMapper.updateNum(ccInStock.getCcId(),ccInStock.getCcNum());
            return id;
        }
        return State;
    }

    public  void  adopt(Integer yhId, Timestamp time, String dpBian){
        dpAllocationMapper.adopt(yhId, time, dpBian);
    }

    public   String  automatic(String head){
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String date = f.format(new Date());
        List<DpAllocation> list = dpAllocationMapper.selectPager(); // 调用Service中的方法获取SQL中的数据
        if(list.size() > 0){
            String n = list.get(0).getDpBian();
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

    public List<JcGoods> selectByWhid(Integer out) {
        return dpAllocationMapper.selectByWhid(out);
    }

    public Integer add(Integer outhouse, Integer inhouse, Integer num, Integer gid, Integer yhid, Timestamp timestamp, Integer i) {
        String bian =this.automatic("db");
       return dpAllocationMapper.add(outhouse,inhouse,num,gid,yhid,timestamp,i,bian);
    }
}
