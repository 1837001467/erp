package com.study.mapper;

import com.study.entity.CgTicket;
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
public interface CgTicketMapper{
    Integer addTicket(CgTicket cgTicket);//新增

    List<CgTicket> selectAll();

    Integer updateTickt(CgTicket ticket);

}
