package com.study.mapper;

import com.study.entity.JcGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface JcGoodsMapper{
    //根据商品id查询
    List<JcGoods> selectById(Integer goid);

    List<JcGoods> selectAll(@Param("no")  Integer no,
                            @Param("size") Integer size,
                            @Param("find") String find
    );

}
