package com.study.service;

import com.study.entity.XsOrderdetails;
import com.study.mapper.XsOrderdetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *订单详情
 * @author zzl
 * @since 2021-11-06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class XsOrderdetailsService{
    @Autowired private XsOrderdetailsMapper xsOrderdetailsMapper;
    //根据销售订单id或销售单id查询订单详情表
    public List<XsOrderdetails> selectById(Integer salesId,Integer orderId){
        return xsOrderdetailsMapper.selectById(salesId,orderId);
    }
}
