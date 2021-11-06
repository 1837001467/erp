package com.study.mapper;

import com.study.entity.XsOrderdetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *订单详情
 * @author zzl
 * @since 2021-11-06
 */
@Mapper
public interface XsOrderdetailsMapper{
        //根据销售订单id或销售单id查询订单详情表
        List<XsOrderdetails> selectById(Integer salesId,Integer orderId);
}
