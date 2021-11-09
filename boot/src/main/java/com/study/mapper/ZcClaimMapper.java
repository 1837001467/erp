package com.study.mapper;

import com.study.entity.LyDetails;
import com.study.entity.ZcClaim;
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
public interface ZcClaimMapper{
    //查询所有领用记录
    List<ZcClaim>  selectAll();
    //修改领用记录状态
    Integer  update(@Param("zcId") Integer  zcId,@Param("zcState") Integer  zcState);
    //根据领用主键查询领用详情
    List<LyDetails>  selectById(Integer zcId);
<<<<<<< HEAD

    Integer   add( ZcClaim zcClaim);

    Integer  addLyDetails(LyDetails  lyDetails);

    Integer  adopt(@Param("yhId")Integer yhId, @Param("time")Timestamp  time,@Param("zcId") Integer  zcId);

=======
    //新增领用记录
    Integer   add( ZcClaim zcClaim);
    //添加领用详情
    Integer  addLyDetails(LyDetails  lyDetails);
    //给领用记录写入审批人
    Integer  adopt(@Param("yhId")Integer yhId, @Param("time")Timestamp  time,@Param("zcId") Integer  zcId);
    //根据领用主键查询领用记录
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
    ZcClaim  selectId(Integer zcid);
}
