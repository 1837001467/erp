package com.study.service;

import com.study.mapper.RkApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public   Integer   cgAdd(String stCode){
        //1.查询到订单详情

        //2.生成入库申请

        //3.生成入库申请详情

        return   null;
    }
}
