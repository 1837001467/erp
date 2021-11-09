package com.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.entity.CcStock;
import com.study.entity.KcStock;
import com.study.entity.LyDetails;
import com.study.entity.ZcClaim;
import com.study.mapper.CcStockMapper;
import com.study.mapper.KcStockMapper;
import com.study.mapper.ZcClaimMapper;
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
public class KcStockService{
    @Autowired
    private ZcClaimMapper zcClaimMapper;
    @Autowired
    private KcStockMapper kcStockMapper;
    @Autowired
    private CcStockMapper ccStockMapper;

<<<<<<< HEAD
    public   Integer  update(Integer zcId,Integer yuId){
        //1.状态改变，写入审批人，审批时间
        zcClaimMapper.update(zcId, 1);
=======
    public  Integer  update(Integer zcId,Integer yuId){
        //1.状态改变，写入审批人，审批时间
       Integer state = zcClaimMapper.update(zcId, 1);
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        this.adopt(zcId,yuId,new Timestamp(System.currentTimeMillis()));
        //2.生成一条库存变动记录
        this.change(zcId,"领用出库");
        //3.库存减少
        this.stockChange(zcId);
<<<<<<< HEAD
        return 0;
=======
        return state;
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
    }
    public  Integer  adopt(Integer zcId,Integer yhId,Timestamp time){
        return zcClaimMapper.adopt(yhId, time, zcId);
    }
<<<<<<< HEAD
    public  Integer  change(Integer  zcid,String  type){
=======
    public  void  change(Integer  zcid,String  type){
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        ZcClaim zcClaim = zcClaimMapper.selectId(zcid);
        List<LyDetails> lyDetails = zcClaimMapper.selectById(zcid);
        if(lyDetails.size()!=0){
            for (LyDetails lyDetail : lyDetails) {
                KcStock  kcStock =new KcStock();
                kcStock.setKcNum(lyDetail.getLyNum());
                kcStock.setKcType(type);
                kcStock.setWh(zcClaim.getWh());
                kcStock.setUser(zcClaim.getShen());
                kcStock.setGoods(lyDetail.getGoods());
                kcStock.setKcTime(new Timestamp(System.currentTimeMillis()));
                kcStock.setKcBian(this.automatic());
                kcStockMapper.change(kcStock);
            }
<<<<<<< HEAD
            return 1;
        }else{
            return 0;
=======
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        }
    }


<<<<<<< HEAD
    public Integer stockChange(Integer zcid){
=======
    public void stockChange(Integer zcid){
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        ZcClaim zcClaim = zcClaimMapper.selectId(zcid);
        List<LyDetails> lyDetails = zcClaimMapper.selectById(zcid);

        if(lyDetails.size()!=0){
            for (LyDetails lyDetail : lyDetails) {
                CcStock ccStock = ccStockMapper.selectByWidAndGid(zcClaim.getWh().getWhId(),lyDetail.getGoods().getGoId() );
                ccStock.setCcNum(ccStock.getCcNum()-lyDetail.getLyNum());
                ccStockMapper.updateNum(ccStock.getCcId(),ccStock.getCcNum());
            }
<<<<<<< HEAD
            return 1;
        }else{
            return 0;
=======
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        }
    }

    //自动生成编号
    public   String  automatic(){
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String date = f.format(new Date());
        List<KcStock> list = kcStockMapper.selectAll(); // 调用Service中的方法获取SQL中的数据
        if(list.size() > 0){
            String n = list.get(0).getKcBian();
            int intNumber = Integer.parseInt(n.substring(10));
            intNumber++;
            String Number = String.valueOf(intNumber);
            for (int i = 0; i < 3; i++){
                Number = Number.length() < 3 ? "0" + Number : Number;
            }
            return ("kc" + date + Number);
        }else{
            return ( "kc" + date + "001");
        }
    }

    public PageInfo<KcStock> selectByPager(Integer pageNO, Integer pageSize,String kcBian) {
        PageHelper.startPage(pageNO,pageSize);/*开启分页模式*/
        List<KcStock> list = kcStockMapper.selectPager(kcBian);/*调用mapper的查询方法*/
        return new PageInfo(list);/*将查询结果封装到PageInfo对象中并返回*/
    }
}

