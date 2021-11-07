package com.study.service;

import com.study.entity.CgPrice;
import com.study.entity.QxUser;
import com.study.mapper.CgPriceMapper;
import com.study.mapper.QxUserMapper;
import com.study.vo.SearchPriceByPager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
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
public class CgPriceService{
    @Autowired
    CgPriceMapper mapper;
    @Autowired
    QxUserMapper qxUserMapper;

    public List<CgPrice> SearchPriceByPager(SearchPriceByPager vo){
        return  mapper.selectByKeyword(vo);
    }

    //审批
    public Integer examine(Integer prid,String spidea,String applystate){
        System.out.println("prid="+prid+"spidea="+spidea+"applystate="+applystate);
        Timestamp nowtime= new Timestamp(System.currentTimeMillis());
        CgPrice cgPrice= mapper.selectByPrid(prid);
        cgPrice.setPrSptime(nowtime);
        cgPrice.setPrSpopinon(spidea);
        if(applystate.equals("1")){//同意
            cgPrice.setPrState(1);
        }else{//不同意
            cgPrice.setPrState(3);
        }
        //采购部门主管
        QxUser qxUser=qxUserMapper.selectCgZg();
        cgPrice.setSppeo(qxUser);
        return mapper.updateCgPrice(cgPrice);
    }

}
