package com.study.service;

import com.study.entity.JcGoods;
import com.study.entity.XsOrderdetails;
import com.study.entity.XsSalesorder;
import com.study.mapper.JcGoodsMapper;
import com.study.mapper.XsOrderdetailsMapper;
import com.study.mapper.XsProceedsMapper;
import com.study.mapper.XsSalesorderMapper;
import com.study.vo.XsOrderAll;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
public class XsSalesorderService{
    @Autowired private XsSalesorderMapper xsSalesorderMapper;
    @Autowired private XsOrderdetailsMapper xsOrderdetailsMapper;
    @Autowired private JcGoodsMapper jcGoodsMapper;
    @Autowired private XsProceedsMapper xsProceedsMapper;
    //销售订单表多查询所有
    public List<XsSalesorder> selectAll(){
        List<XsSalesorder> list = xsSalesorderMapper.selectAll();
        List<XsSalesorder> xsOrder = new ArrayList<>();
        System.out.println("开始循环");
        for(XsSalesorder order : list){
            System.out.println("订单详情编号："+order.getOrderId());
            List<XsOrderdetails> details = xsOrderdetailsMapper.selectById(null,order.getOrderId());
            order.setDetails(details);
            for(XsOrderdetails xsdetails : details){
                System.out.println("商品编号："+xsdetails.getGoId());
                List<JcGoods> jcGoods = jcGoodsMapper.selectById(xsdetails.getGoId());
                order.setGoods(jcGoods);
            }
            xsOrder.add(order);
        }
        System.out.println("销售订单信息："+xsOrder);
        return xsOrder;
    }
    //销售订单表多条件查询
    public List<XsSalesorder> selectById(XsSalesorder xsSalesorder){
        return xsSalesorderMapper.selectById(xsSalesorder);
    }
    //销售订单表新增
    public Integer addOrder(XsOrderAll order){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        BigDecimal money = new BigDecimal(0);
        List<JcGoods> goods = order.getGoods();
        for(int i = 0;i<goods.size();i++){
            System.out.println(goods.get(i).getgName()+"的总价为："+goods.get(i).getgPrice().multiply(BigDecimal.valueOf(goods.get(i).getgBian())));
            BigDecimal num = goods.get(i).getgPrice().multiply(BigDecimal.valueOf(goods.get(i).getgBian()));
            money = money.add(num);
        }
        System.out.println("商品总价为："+money);
        XsSalesorder xsorder = new XsSalesorder(null,order.getYhId(),null,order.getKhId(),null,order.getOrderYard(),order.getOrderName(),null,order.getOrderSite(),order.getOrderGoods(),order.getOrderLinkman(),order.getOrderPhone(),money,time,null,"已申请",null,null);
        Integer i = xsSalesorderMapper.addOrder(xsorder);
        Integer orderId = xsSalesorderMapper.selectIdMax();
        System.out.println("id:"+orderId);
        for (JcGoods good : order.getGoods()){
            XsOrderdetails detalis = new XsOrderdetails(null,null,orderId,good.getgBian(),good.getGoId());
            xsOrderdetailsMapper.addDetails(detalis);
        }
        return 1;
    }
    //修改销售订单状态
    public Integer updateOrderSetState(String orderState,Integer QxYhId,Integer orderId){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        System.out.println("订单id"+orderId);
        System.out.println("订单状态"+orderState);
        Integer i = null;
        if(orderState.equals("已申请")){
            i = xsSalesorderMapper.updateOrderSetState("已审核",QxYhId,orderId,time);

        }
        return 1;
    }
}
