package com.study.mapper;

import com.study.entity.XsOrderdetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface XsOrderdetailsMapper{
        //根据销售订单id或销售单id查询订单详情表
        List<XsOrderdetails> selectById(Integer salesId,Integer orderId);
}
