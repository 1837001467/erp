package com.study.service;

import com.study.entity.*;
import com.study.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
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
public class XsProceedsService{
    @Autowired private XsProceedsMapper xsProceedsMapper;
    @Autowired private JcCustomerMapper jcCustomerMapper;
    @Autowired private XsSalesorderMapper xsSalesorderMapper;
    @Autowired private XsBillMapper xsBillMapper;
    @Autowired private XsReceiptMapper xsReceiptMapper;
    @Autowired private CkApplyMapper ckApplyMapper;

    //新增收款单
    public Integer addProceeds(XsProceeds xsProceeds){
        return xsProceedsMapper.addProceeds(xsProceeds);
    }
    //收款单查询所有
    public List<XsProceeds> selectAll(){
        List<XsProceeds> list = xsProceedsMapper.selectAll();
        List<XsProceeds> xsProceeds = new ArrayList<>();
        for(XsProceeds proceeds : list){
            System.out.println("proceeds"+proceeds);
            JcCustomer jcCustomer = jcCustomerMapper.selectById(proceeds.getKhId());
            proceeds.setProceedsName(jcCustomer.getKhName());
            XsSalesorder xsSalesorder =xsSalesorderMapper.selectByOrderId(proceeds.getSalesId());
            proceeds.setProceedsMoney(xsSalesorder.getOrderMoney());
            proceeds.setOrderYard(xsSalesorder.getOrderYard());
            proceeds.setYonghuName("戴莉");
            xsProceeds.add(proceeds);
        }
        return xsProceeds;
    }
    //收款单审核
    public Integer updateProceeds(String proceedsState, Integer qxYhId, Integer proceedsId,XsProceeds xsProceeds){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        if(proceedsState.equals("已申请")){
            xsProceedsMapper.updateProceeds("已审核",qxYhId,proceedsId,time);
            System.out.println("销售订单："+xsProceeds.getSalesId());
            Calendar now = Calendar.getInstance();
            String year = String.valueOf(now.get(Calendar.YEAR));
            String month = String.valueOf(now.get(Calendar.MONTH)+1);
            String day = String.valueOf(now.get(Calendar.DAY_OF_MONTH));
            String num = String.valueOf((int)((Math.random()*9+1)*1000));
            String billYard = "FP"+year+month+day+num;
            System.out.println("随机码"+num);
            System.out.println("编码："+billYard);
            System.out.println("客户id"+xsProceeds.getKhId());
            XsBill xsBill = new XsBill(null,null,xsProceeds.getKhId(),xsProceeds.getYhId(),xsProceeds.getSalesId(), xsProceeds.getProceedsMoney(),"现金","",time,billYard);
            Integer x = xsBillMapper.addBill(xsBill);
            if(x>0){
                System.out.println("发票新增成功");
            }else {
                System.out.println("发票新增失败");
            }
            String receiptYard = "YSJZ"+year+month+day+num;
            XsReceipt xsReceipt = new XsReceipt(null,xsProceeds.getYhId(),xsProceeds.getKhId(),receiptYard,xsProceeds.getProceedsMoney(),"现金","",time,null,"已到账");
            //xsReceipt.setSalesId(xsProceeds.getSalesId());
            xsReceipt.setSalesId(xsProceeds.getProceedsId());
            Integer c = xsReceiptMapper.addReceipt(xsReceipt);
            if(c>0){
                System.out.println("应收记账新增成功");
            }else {
                System.out.println("应收记账新增失败");
            }

//            System.out.println("开始新增出库申请");
//            CkApply ckApply = new CkApply();
//            String CkBian = "CK"+year+month+day+num;
//            ckApply.setCkBian(CkBian);
//            XsSalesorder order = xsSalesorderMapper.selectByOrderId(xsProceeds.getSalesId());
//            System.out.println("销售订单编号："+order.getOrderYard());
//            ckApply.setSalesYard(order.getOrderYard());
//            ckApply.setCkApplicationtime(time);
//            //申请人
//            QxUser squser = new QxUser();
//            squser.setYhId(2);
//            ckApply.setYhShen(squser);
//            //审批人
//            QxUser spuser = new QxUser();
//            spuser.setYhId(1);
//            ckApply.setYhPi(spuser);
//            ckApply.setCkType("销售出库");
//            ckApply.setCkState(1);
//            Timestamp nowtime= new Timestamp(System.currentTimeMillis());
//            ckApply.setCkApprovaltime(nowtime);
//            Integer z = ckApplyMapper.addCkApply(ckApply);
//            if(z>0){
//                System.out.println("出库单新增成功");
//            }else{
//                System.out.println("出库单新增失败");
//            }
        }
        return 1;
    }
}
