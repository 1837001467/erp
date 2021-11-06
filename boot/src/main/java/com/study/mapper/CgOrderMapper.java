package com.study.mapper;

import com.study.entity.CgOrder;
import org.apache.ibatis.annotations.Mapper;

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
public interface CgOrderMapper{
    List<CgOrder> list();
}
