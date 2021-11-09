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
    List<ZcClaim>  selectAll();

    Integer  update(@Param("zcId") Integer  zcId,@Param("zcState") Integer  zcState);

    List<LyDetails>  selectById(Integer zcId);

    Integer   add( ZcClaim zcClaim);

    Integer  addLyDetails(LyDetails  lyDetails);

    Integer  adopt(@Param("yhId")Integer yhId, @Param("time")Timestamp  time,@Param("zcId") Integer  zcId);

    ZcClaim  selectId(Integer zcid);
}
