package com.study.mapper;

import com.study.entity.XsBill;
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
public interface XsBillMapper{
    List<XsBill> selectAll();
    Integer addBill(XsBill xsBill);
    XsBill selectById(Integer billId);
    Integer selecIdMax();
}
