package com.study.mapper;

import com.study.entity.CgPricedetail;
import com.study.entity.JcGoods;
import org.apache.ibatis.annotations.Mapper;

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
public interface CgPricedetailMapper{
    Integer addDetail(CgPricedetail detail);//新增采购报价详情

}
