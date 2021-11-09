package com.study.mapper;

import com.study.entity.QxJsdn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 权限表格 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-11-06
 */
@Mapper
public interface QxJsdnMapper{
    //角色授权时查询
 List<QxJsdn> sqcx(Integer posId);
 //用户权限查询
 List<QxJsdn> dlqx(Integer yhId);
    //权限查询
List<QxJsdn> sycx();
}
