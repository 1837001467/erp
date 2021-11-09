package com.study.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.entity.JcGoods;
import com.study.entity.XsOrderdetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class XsOrderAll {
    private List<JcGoods> goods;//商品
    private List<AddOrder> order;//订单详情
    private Integer orderId;//销售订单id
    private Integer detailsNum;//商品数量
    private Integer salesId;//销售单id
    private String orderYard;//销售订单码
    private String orderName;//客户名
    private String orderNames;//联系人
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    private Timestamp goodsTime;//交货时间
    private String orderSite;//交货地址
    private String orderGoods;//交货方式
    private String orderLinkman;//联系人
    private String orderPhone;//联系电话
    private BigDecimal orderMoney;//商品总价
    private Integer detalisId;//订单详情id
    private String yhName;//申请人姓名
    private Integer yhId;//申请人
    private Integer qxYhId;//审核人
    private Timestamp orderTime;//销售订单申请时间
    private Timestamp orderTimes;//销售订单审核时间
    private String orderState;//销售订单状态
    private Integer khId;//客户id
    private String salesYard;//销售单编号
    private Integer whId;//仓库id
    private String salesWay;//收款方式
    private String salesAccount;//收款账户
    private Integer billId;//发票id

    public List<JcGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<JcGoods> goods) {
        this.goods = goods;
    }

    public List<AddOrder> getOrder() {
        return order;
    }

    public void setOrder(List<AddOrder> order) {
        this.order = order;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getDetailsNum() {
        return detailsNum;
    }

    public void setDetailsNum(Integer detailsNum) {
        this.detailsNum = detailsNum;
    }

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public String getOrderYard() {
        return orderYard;
    }

    public void setOrderYard(String orderYard) {
        this.orderYard = orderYard;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderNames() {
        return orderNames;
    }

    public void setOrderNames(String orderNames) {
        this.orderNames = orderNames;
    }

    public Timestamp getGoodsTime() {
        return goodsTime;
    }

    public void setGoodsTime(Timestamp goodsTime) {
        this.goodsTime = goodsTime;
    }

    public String getOrderSite() {
        return orderSite;
    }

    public void setOrderSite(String orderSite) {
        this.orderSite = orderSite;
    }

    public String getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(String orderGoods) {
        this.orderGoods = orderGoods;
    }

    public String getOrderLinkman() {
        return orderLinkman;
    }

    public void setOrderLinkman(String orderLinkman) {
        this.orderLinkman = orderLinkman;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getDetalisId() {
        return detalisId;
    }

    public void setDetalisId(Integer detalisId) {
        this.detalisId = detalisId;
    }

    public String getYhName() {
        return yhName;
    }

    public void setYhName(String yhName) {
        this.yhName = yhName;
    }

    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public Integer getQxYhId() {
        return qxYhId;
    }

    public void setQxYhId(Integer qxYhId) {
        this.qxYhId = qxYhId;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Timestamp getOrderTimes() {
        return orderTimes;
    }

    public void setOrderTimes(Timestamp orderTimes) {
        this.orderTimes = orderTimes;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Integer getKhId() {
        return khId;
    }

    public void setKhId(Integer khId) {
        this.khId = khId;
    }

    public String getSalesYard() {
        return salesYard;
    }

    public void setSalesYard(String salesYard) {
        this.salesYard = salesYard;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public String getSalesWay() {
        return salesWay;
    }

    public void setSalesWay(String salesWay) {
        this.salesWay = salesWay;
    }

    public String getSalesAccount() {
        return salesAccount;
    }

    public void setSalesAccount(String salesAccount) {
        this.salesAccount = salesAccount;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }
}
