package com.study.mapper;

import com.study.entity.XsReceipt;
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
public interface XsReceiptMapper {
    List<XsReceipt> selectAll();
    Integer addReceipt(XsReceipt xsReceipt);
}
