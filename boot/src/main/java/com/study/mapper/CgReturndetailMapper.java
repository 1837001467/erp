package com.study.mapper;

import com.study.entity.CgReturndetail;
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
public interface CgReturndetailMapper{
    Integer addDetail(CgReturndetail cgReturndetail);//新增采购报价详情

}
