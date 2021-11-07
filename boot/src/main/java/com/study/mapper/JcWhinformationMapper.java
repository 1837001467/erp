package com.study.mapper;

import com.study.entity.JcWhinformation;
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
public interface JcWhinformationMapper{
    List<JcWhinformation> selectAll();

    List<JcWhinformation> selectAll(@Param("no")  Integer no,
                                    @Param("size") Integer size,
                                    @Param("find") String find
    );
}
