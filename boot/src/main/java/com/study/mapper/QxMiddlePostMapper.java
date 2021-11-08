package com.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.entity.QxMiddlePost;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.stream.BaseStream;

/**
 * <p>
 * 职位权限中间表格 Mapper 接口
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Mapper
public interface QxMiddlePostMapper extends BaseMapper<QxMiddlePost> {
//    批量新增
    int insertMiddle(Integer posId,List<Integer> listArr);
    @Delete("delete from qx_middle_post where pos_id=#{posId}")
    public void delet(Integer posId);
}
