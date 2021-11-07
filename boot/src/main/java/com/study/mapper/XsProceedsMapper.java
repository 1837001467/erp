package com.study.mapper;

import com.study.entity.XsProceeds;
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
public interface XsProceedsMapper{
    //新增收款单
    Integer addProceeds(XsProceeds xsProceeds);
    //查询所有收款单
    List<XsProceeds> selectAll();
    //收款单审核
    Integer updateProceeds(String proceedsState, Integer qxYhId, Integer proceedsId, Timestamp proceedsTimes);
}
