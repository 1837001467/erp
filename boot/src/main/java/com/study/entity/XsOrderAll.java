package com.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Integer orderId;//销售订单id
    private Integer detailsNum;//商品数量
    private Integer salesId;//销售单id
    private String orderYard;//销售订单码
    private String orderName;//客户名
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    private Timestamp goodsTime;//交货时间
    private String orderSite;//交货地址
    private String orderGoods;//交货方式
    private String orderLinkman;//联系人
    private String orderPhone;//联系电话
    private BigDecimal orderMoney;//商品总价
    private Integer detalisId;//订单详情id
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
}
