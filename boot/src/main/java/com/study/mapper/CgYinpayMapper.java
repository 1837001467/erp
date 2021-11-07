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
    Integer addYinPay(CgYinpay yinpay);//新增

    List<CgYinpay> selectAll();

    Integer updateById(CgYinpay cgYinpay);


}
