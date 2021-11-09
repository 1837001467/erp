package com.study.service;

import com.study.entity.CgTicket;
import com.study.entity.CgYinpay;
import com.study.mapper.CgTicketMapper;
import com.study.mapper.CgYinpayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
public class CgYinpayService{
    @Autowired
    CgYinpayMapper mapper;
    @Autowired
    CgTicketMapper ticketMapper;

    //查询所有
    public List<CgYinpay> all(){
        return mapper.selectAll();
    }

    //付款操作
<<<<<<< HEAD
    public Integer fukuan(Integer yiid, String way, String fktype, BigDecimal totalmoney){
=======
    public Integer fukuan(Integer yiid, String way, String fktype){
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        //1、改应付款单状态
        Timestamp nowtime= new Timestamp(System.currentTimeMillis());
        CgYinpay cgYinpay=new CgYinpay();
        cgYinpay.setYiId(yiid);
        cgYinpay.setYiWay(way);
        cgYinpay.setYiType(fktype);
        cgYinpay.setYiState(1);
        int i=mapper.updateById(cgYinpay);
        if(i>0){
            //新增收票记录
            CgTicket cgTicket=new CgTicket(null,nowtime,0);
            cgTicket.setCgYinpay(cgYinpay);
            i=ticketMapper.addTicket(cgTicket);
        }
        return i;
    }

}
