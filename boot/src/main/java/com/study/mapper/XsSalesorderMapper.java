package com.study.mapper;

import com.study.entity.XsSalesorder;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-11-06
 */
@Mapper
public interface XsSalesorderMapper {
    //销售订单表多条件查询
    List<XsSalesorder> selectAll();
    //销售订单表多条件查询
    List<XsSalesorder> selectById(XsSalesorder xsSalesorder);
    //销售订单表新增
    Integer addOrder(XsSalesorder xsSalesorder);
    //查询最大索引
    Integer selectIdMax();
    //修改销售订单状态
<<<<<<< HEAD
    Integer updateOrderSetState(String orderState, Integer QxYhId, Integer orderId, Timestamp orderTimes);
=======
    Integer updateOrderSetState(String orderState, Integer qxYhId, Integer orderId, Timestamp orderTimes);
    //销售订单表根据id查询
    XsSalesorder selectByOrderId(Integer orderId);
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
}
