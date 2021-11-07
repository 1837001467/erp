package com.study.mapper;

import com.study.entity.CcStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-11-06
 */
@Mapper
public interface CcStockMapper{
    CcStock  selectByWidAndGid(@Param("whId") Integer  whId,@Param("gId") Integer  gId);

    Integer  updateNum(@Param("ccId") Integer ccId,@Param("ccNum") Integer ccNum);
}
