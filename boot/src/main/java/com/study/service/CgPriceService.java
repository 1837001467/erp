package com.study.service;

import com.study.entity.CgPrice;
import com.study.mapper.CgPriceMapper;
import com.study.vo.SearchPriceByPager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<CgPrice> SearchPriceByPager(SearchPriceByPager vo){
        return  mapper.selectByKeyword(vo);
    }

    //审批
//    public Integer examine(Integer prid,String spidea,String applystate){
//        Timestamp nowtime= new Timestamp(System.currentTimeMillis());
//        Optional<CgPrice> cgPrice=dao.findById(prid);
//
//    }

}
