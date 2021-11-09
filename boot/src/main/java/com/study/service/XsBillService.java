package com.study.service;

import com.study.entity.JcCustomer;
import com.study.entity.XsBill;
import com.study.entity.XsProceeds;
import com.study.entity.XsSalesorder;
import com.study.mapper.JcCustomerMapper;
import com.study.mapper.XsBillMapper;
import com.study.mapper.XsProceedsMapper;
import com.study.mapper.XsSalesorderMapper;
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
public class XsBillService{
    @Autowired private XsBillMapper xsBillMapper;
    @Autowired private JcCustomerMapper jcCustomerMapper;
    @Autowired private XsProceedsMapper xsProceedsMapper;
    public List<XsBill> selectAll(){
        List<XsBill> list = xsBillMapper.selectAll();

        List<XsBill> bill = new ArrayList<>();
        for (XsBill xsBill : list){
            System.out.println("xsBill====="+xsBill);
            JcCustomer jcCustomer = jcCustomerMapper.selectById(xsBill.getKhId());
            xsBill.setKhName(jcCustomer.getKhName());
            System.out.println("xsBill.getSalesId()="+xsBill.getSalesId());
            XsProceeds xsProceeds =xsProceedsMapper.selectBySalesId(xsBill.getSalesId());
            System.out.println("xsProceeds="+xsProceeds);
            xsBill.setOrderYard(xsProceeds.getProceedsYard());
            xsBill.setYonghuName("戴莉");
            bill.add(xsBill);
        }
        return bill;
    }
    public Integer addBill(XsBill xsBill){
        Integer i = xsBillMapper.addBill(xsBill);
        return i;
    }
    public XsBill selectById(Integer billId){
        return xsBillMapper.selectById(billId);
    }
    public Integer billId(){
        return xsBillMapper.selecIdMax();
    }
}
