package com.study.mapper;

import com.study.entity.CgPrice;
import com.study.vo.SearchPriceByPager;
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
public interface CgPriceMapper{
    List<CgPrice> selectByKeyword(SearchPriceByPager vo);//条件搜索

    CgPrice selectByPrid(Integer prid);//通过主键查找具体的采购报价单

    Integer updateCgPrice(CgPrice cgPrice);//修改采购报价单

    Integer updateStateById(Integer prId);//根据主键修改

    Integer addCgprice(CgPrice cgPrice);//新增采购报价单





}
