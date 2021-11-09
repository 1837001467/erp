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
    //根据商品号和仓库号查询库存
    CcStock  selectByWidAndGid(@Param("whId") Integer  whId,@Param("gId") Integer  gId);
    //根据 库存主键写入库存
    Integer  updateNum(@Param("ccId") Integer ccId,@Param("ccNum") Integer ccNum);
}
