package com.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.entity.QxPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 职位表 Mapper 接口
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Mapper
public interface QxPostMapper extends BaseMapper<QxPost> {
    List<QxPost> pstcx(String seach);
}
