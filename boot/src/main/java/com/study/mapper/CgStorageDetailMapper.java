package com.study.mapper;

import com.study.entity.CgStorageDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 邱艳丽
 * @date 2021-11-07
 */
@Mapper
public interface CgStorageDetailMapper {
    Integer addSdDetail(CgStorageDetail detail);//新增详情

}
