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
<<<<<<< HEAD
    CgStorage  selectBystCode(String stCode);
    Integer  update(@Param("rkId") Integer  rkId, @Param("rkState") Integer  rkState);
    Integer  updateTwo(@Param("stCode") String  stCode, @Param("rkState") Integer  rkState);
    List<RkApply>  selectById(Integer rkId);
    List<CgStorageDetail> selectBystId(Integer stId);
    List<RkApply> selectAll();
    Integer   addDetails(RkDetails details);
    Integer  cgAdd(RkApply rkApply);

    Integer adopt(Integer yhId, Timestamp time, Integer rkId);
=======
    //根据订单入库编码查询
    CgStorage  selectBystCode(String stCode);
   //修改入库请求状态
    Integer  update(@Param("rkId") Integer  rkId, @Param("rkState") Integer  rkState);
    //修改订单入库状态
    Integer  updateTwo(@Param("stCode") String  stCode, @Param("rkState") Integer  rkState);
    //根据请求ID查询
    List<RkApply>  selectById(Integer rkId);
    //根据订单入库ID查询订单入库详情
    List<CgStorageDetail> selectBystId(Integer stId);
    //查询所有请求入库
    List<RkApply> selectAll();
    //添加入库详情
    Integer   addDetails(RkDetails details);
    //添加订单入库
    Integer  cgAdd(RkApply rkApply);
    //给入库请求写入审批人
    Integer adopt(Integer yhId, Timestamp time, Integer rkId);
    //给订单入库写入审批人
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
    Integer adoptTwo(Integer yhId, Timestamp time, String stCode);
}
