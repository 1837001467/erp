package com.study.mapper;

import com.study.entity.KcStock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

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
public interface KcStockMapper {
    Integer  change(KcStock kcStock);

    List<KcStock>  selectAll();

    List<KcStock> selectPager(String kcBian);
}
