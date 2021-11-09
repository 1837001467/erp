package com.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.entity.LyDetails;
import com.study.entity.ZcClaim;
import com.study.mapper.ZcClaimMapper;
import com.study.vo.ZcClaimVo;
import org.apache.ibatis.annotations.Param;
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
public class ZcClaimService{
       @Autowired
    ZcClaimMapper  mapper;

    public PageInfo<ZcClaim> selectByPager(Integer no, Integer size){
        PageHelper.startPage(no,size);/*开启分页模式*/
        List<ZcClaim> list = mapper.selectAll();/*调用mapper的查询方法*/
        return new PageInfo(list);/*将查询结果封装到PageInfo对象中并返回*/
    }

    public  Integer  update(Integer  zcId,Integer zcState){
        Integer  state = mapper.update(zcId, zcState);
        return  state;
    }

    public  List<LyDetails> lookDetails(Integer zxId){
        return mapper.selectById(zxId);
    }

    public   Integer   add(ZcClaimVo vo){
        //1.新增领用记录
        ZcClaim  zcClaim  = new ZcClaim();
        zcClaim.setZcText(vo.getZcText());
        zcClaim.setBm(vo.getBm());
        zcClaim.setWh(vo.getCangku());
        zcClaim.setZcApplicationtime(new Timestamp(System.currentTimeMillis()));
        zcClaim.setZcState(0);
        zcClaim.setZcBian(this.automatic());
        zcClaim.setShen(vo.getUser());
        mapper.add(zcClaim);
        System.out.println(zcClaim.getZcId());
        //新增领用详情
        LyDetails  lyDetails   =  new LyDetails();
        lyDetails.setGoods(vo.getCommodity());
        lyDetails.setLyNum(vo.getLyNum());
        lyDetails.setZcId(zcClaim.getZcId());
<<<<<<< HEAD
        mapper.addLyDetails(lyDetails);
        return 1;
=======
        return mapper.addLyDetails(lyDetails);
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
    }



    //自动生成编号
    public   String  automatic(){
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String date = f.format(new Date());
        List<ZcClaim> list = mapper.selectAll(); // 调用Service中的方法获取SQL中的数据
        if(list.size() > 0){
            String n = list.get(0).getZcBian();
            int intNumber = Integer.parseInt(n.substring(10));
            intNumber++;
            String Number = String.valueOf(intNumber);
            for (int i = 0; i < 3; i++){
                 Number = Number.length() < 3 ? "0" + Number : Number;
            }
            return ("ly" + date + Number);
        }else{
            return ( "ly" + date + "001");
        }
    }
}
