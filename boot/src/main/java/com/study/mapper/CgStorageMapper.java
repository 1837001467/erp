package com.study.mapper;

import com.study.entity.CgStorage;
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
public interface CgStorageMapper {
    List<CgStorage> all();//所有

    Integer addstorage(CgStorage cgStorage);//新增入库单

    Integer updateCgStorage(CgStorage cgStorage);//修改审核相关数据

    CgStorage selectByCode(String stCode);//根据入库编码进行查找

}
