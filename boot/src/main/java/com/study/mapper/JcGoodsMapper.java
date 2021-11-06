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
 * @author zzl
 * @since 2021-11-06
 */
@Mapper
public interface JcGoodsMapper{

    List<JcGoods> selectAll(@Param("no")  Integer no,
                            @Param("size") Integer size,
                            @Param("find") String find
    );

}
