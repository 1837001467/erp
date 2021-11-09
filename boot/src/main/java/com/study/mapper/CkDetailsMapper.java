package com.study.mapper;

import com.study.entity.CkApply;
import com.study.entity.CkDetails;
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
public interface CkDetailsMapper{
    Integer addCkDetailsMapper(CkDetails ckDetails);//新增出库详情

}
