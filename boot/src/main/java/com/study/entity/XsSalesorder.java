package com.study.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class XsSalesorder implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer orderId;

    private Integer yhId;

    private Integer salesId;

    private Integer khId;

    private Integer qxYhId;

    private String orderYard;

    private String orderName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    private Timestamp goodsTime;

    private String orderSite;

    private String orderGoods;

    private String orderLinkman;

    private String orderPhone;

    private BigDecimal orderMoney;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    private Timestamp orderTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    private Timestamp orderTimes;

    private String orderState;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    private Timestamp date1;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    private Timestamp date2;

    @Override
    public String toString() {
        return "XsSalesorder{" +
                "orderId=" + orderId +
                ", yhId=" + yhId +
                ", salesId=" + salesId +
                ", khId=" + khId +
                ", qxYhId=" + qxYhId +
                ", orderYard='" + orderYard + '\'' +
                ", orderName='" + orderName + '\'' +
                ", goodsTime=" + goodsTime +
                ", orderSite='" + orderSite + '\'' +
                ", orderGoods='" + orderGoods + '\'' +
                ", orderLinkman='" + orderLinkman + '\'' +
                ", orderPhone='" + orderPhone + '\'' +
                ", orderMoney=" + orderMoney +
                ", orderTime=" + orderTime +
                ", orderTimes=" + orderTimes +
                ", orderState='" + orderState + '\'' +
                ", date1=" + date1 +
                ", date2=" + date2 +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public Integer getKhId() {
        return khId;
    }

    public void setKhId(Integer khId) {
        this.khId = khId;
    }

    public Integer getQxYhId() {
        return qxYhId;
    }

    public void setQxYhId(Integer qxYhId) {
        this.qxYhId = qxYhId;
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

    public Timestamp getDate1() {
        return date1;
    }

    public void setDate1(Timestamp date1) {
        this.date1 = date1;
    }

    public Timestamp getDate2() {
        return date2;
    }

    public void setDate2(Timestamp date2) {
        this.date2 = date2;
    }
}
