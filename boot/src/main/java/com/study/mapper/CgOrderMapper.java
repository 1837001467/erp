package com.study.mapper;

import com.study.entity.CgOrder;
import com.study.vo.SearchOrderAndPage;
import org.apache.ibatis.annotations.Mapper;

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
public interface CgOrderMapper{
    List<CgOrder> list();

    List<CgOrder> searchByKeyword(SearchOrderAndPage vo);

    Integer addOrder(CgOrder cgOrder);//新增

    Integer updateCgOrder(CgOrder cgOrder);//修改审批相关数据

    Integer updataCgStateById(Integer orId);//根据订单id修改订单状态


}
