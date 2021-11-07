package com.study.mapper;

import com.study.entity.LyDetails;
import com.study.entity.ZcClaim;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
