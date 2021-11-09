package com.study.mapper;

import com.study.entity.CkApply;
import com.study.entity.RkApply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
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
public interface CkApplyMapper {
    //查询所有出库记录
    List<CkApply> selectAll();
    //根据出库主键查询出库记录
    List<CkApply> selectById(Integer ckId);
    //修改出库状态和添加审批人
    Integer update(@Param("ckId") Integer ckId,@Param("ckState") Integer rkState, @Param("yhId")Integer yhId,@Param("time") Timestamp time);

    Integer addCkApply(CkApply ckApply);//新增出库
}
