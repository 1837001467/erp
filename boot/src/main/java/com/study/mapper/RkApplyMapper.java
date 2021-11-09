package com.study.mapper;

import com.study.entity.*;
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
public interface RkApplyMapper {
    CgStorage  selectBystCode(String stCode);
    Integer  update(@Param("rkId") Integer  rkId, @Param("rkState") Integer  rkState);
    Integer  updateTwo(@Param("stCode") String  stCode, @Param("rkState") Integer  rkState);
    List<RkApply>  selectById(Integer rkId);
    List<CgStorageDetail> selectBystId(Integer stId);
    List<RkApply> selectAll();
    Integer   addDetails(RkDetails details);
    Integer  cgAdd(RkApply rkApply);

    Integer adopt(Integer yhId, Timestamp time, Integer rkId);
    Integer adoptTwo(Integer yhId, Timestamp time, String stCode);
}
