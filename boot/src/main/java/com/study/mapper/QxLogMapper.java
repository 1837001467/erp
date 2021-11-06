package com.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.entity.QxDepartment;
import com.study.entity.QxLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 日志表 Mapper 接口
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Mapper
public interface QxLogMapper extends BaseMapper<QxLog> {
    //日志查询
    List<QxLog> rzcx(String seach);
}
