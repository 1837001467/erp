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

    List<CgTicket> selectAll();//查询所有收票

    Integer updateTickt(CgTicket ticket);//修改收票（删除操作）

}
