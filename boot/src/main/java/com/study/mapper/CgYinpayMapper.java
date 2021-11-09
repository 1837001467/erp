package com.study.mapper;

import com.study.entity.CgYinpay;
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
public interface CgYinpayMapper {
    Integer addYinPay(CgYinpay yinpay);//新增收付记录

    List<CgYinpay> selectAll();//查询所有收付记录

    Integer updateById(CgYinpay cgYinpay);//修改收付记录


}
