package com.study.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.study.entity.CgOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Repository
public interface CgOrderMapper extends BaseMapper<CgOrder> {
    List<CgOrder> list();
}
