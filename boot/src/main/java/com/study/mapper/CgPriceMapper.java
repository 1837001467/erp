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
    List<CgPrice> selectByKeyword(SearchPriceByPager vo);

    CgPrice selectByPrid(Integer prid);

    Integer updateCgPrice(CgPrice cgPrice);


}
