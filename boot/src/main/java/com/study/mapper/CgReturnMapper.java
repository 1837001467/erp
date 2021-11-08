package com.study.mapper;

import com.study.entity.CgReturn;
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
public interface CgReturnMapper{
    List<CgReturn> all();

    Integer addTh(CgReturn cgReturn);//新增



}
