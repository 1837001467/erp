package com.study.mapper;

import com.study.entity.JcSupplier;
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
public interface JcSupplierMapper{
    List<JcSupplier> allSuppliers();//获取所有供应商
    //分页查询所有
    List<JcSupplier> selectAll(@Param("no")  Integer no,
                               @Param("size") Integer size,
                               @Param("find") String find
    );
    //更新
    Integer save(JcSupplier jcSupplier);
    List<JcSupplier> selectAll();
}
