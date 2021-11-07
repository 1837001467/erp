package com.study.service;

import com.study.entity.CgTicket;
import com.study.mapper.CgTicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2021-11-06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CgTicketService{
    @Autowired
    CgTicketMapper mapper;

    public List<CgTicket> all(){
        return mapper.selectAll();
    }

    //修改（删除）收票
    public Integer updateTicket(Integer tiid,Integer tistate){
        CgTicket cgTicket=new CgTicket();
        cgTicket.setTiId(tiid);
        if(tistate.equals(0)){
            cgTicket.setTiState(1);
        }else{
            cgTicket.setTiState(0);
        }
        return mapper.updateTickt(cgTicket);
    }
}
