package com.study.mapper;

import com.study.entity.JcCustomer;
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
public interface JcCustomerMapper{
    //客户查询所有
    List<JcCustomer> selectAll();
    //客户根据id查询
    JcCustomer selectById(Integer khId);
}
