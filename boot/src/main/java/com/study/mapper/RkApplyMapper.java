package com.study.mapper;

import com.study.entity.CgStorage;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author
 * @since 2021-11-06
 */
@Mapper
public interface RkApplyMapper {
    CgStorage  selectBystCode(String stCode);
}
