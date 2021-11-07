package com.study.mapper;

import com.study.entity.CgOrderdetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-11-06
 */
@Mapper
public interface CgOrderdetailMapper{
    Integer addOrderDetail(CgOrderdetail orderdetail);

}
