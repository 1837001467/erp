package com.study.service;

import com.study.entity.JcCustomer;
import com.study.entity.XsProceeds;
import com.study.entity.XsReceipt;
import com.study.mapper.JcCustomerMapper;
import com.study.mapper.XsProceedsMapper;
import com.study.mapper.XsReceiptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
public class XsReceiptService{
    @Autowired private XsReceiptMapper xsReceiptMapper;
    @Autowired private JcCustomerMapper jcCustomerMapper;
    @Autowired private XsProceedsMapper xsProceedsMapper;
    public List<XsReceipt> selectAll(){
        List<XsReceipt> list = xsReceiptMapper.selectAll();
        List<XsReceipt> receipts = new ArrayList<>();
        for (XsReceipt xsReceipt : list){
            JcCustomer jcCustomer = jcCustomerMapper.selectById(xsReceipt.getQxYhId());
            xsReceipt.setKhName(jcCustomer.getKhName());
            System.out.println("销售订单id"+xsReceipt.getSalesId());
            System.out.println("xsReceipt="+xsReceipt);
            XsProceeds xsProceeds =xsProceedsMapper.selectById(xsReceipt.getSalesId());
            System.out.println("xsProceeds="+xsProceeds);
            xsReceipt.setOrderYard(xsProceeds.getProceedsYard());
            xsReceipt.setReceiptAcount("戴莉");
            receipts.add(xsReceipt);
        }
        return receipts;
    }
}
