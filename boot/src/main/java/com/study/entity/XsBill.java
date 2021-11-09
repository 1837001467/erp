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
 * @author 
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class XsBill implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer billId;

    private Integer returnId;

    private Integer khId;

    private Integer yhId;

    private Integer salesId;

    private BigDecimal billMoney;

    private String billWay;

    private String billAccount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Timestamp billTime;
<<<<<<< HEAD
=======

    private String billYard;

    private String khName;

    private String orderYard;

    public String getKhName() {
        return khName;
    }

    public void setKhName(String khName) {
        this.khName = khName;
    }

    public String getOrderYard() {
        return orderYard;
    }

    public void setOrderYard(String orderYard) {
        this.orderYard = orderYard;
    }

    private String yonghuName;

    public String getYonghuName() {
        return yonghuName;
    }

    public void setYonghuName(String yonghuName) {
        this.yonghuName = yonghuName;
    }

    public XsBill() {
    }

    public XsBill(Integer billId, Integer returnId, Integer khId, Integer yhId, Integer salesId, BigDecimal billMoney, String billWay, String billAccount, Timestamp billTime, String billYard) {
        this.billId = billId;
        this.returnId = returnId;
        this.khId = khId;
        this.yhId = yhId;
        this.salesId = salesId;
        this.billMoney = billMoney;
        this.billWay = billWay;
        this.billAccount = billAccount;
        this.billTime = billTime;
        this.billYard = billYard;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public Integer getKhId() {
        return khId;
    }

    public void setKhId(Integer khId) {
        this.khId = khId;
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

    public BigDecimal getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(BigDecimal billMoney) {
        this.billMoney = billMoney;
    }

    public String getBillWay() {
        return billWay;
    }

    public void setBillWay(String billWay) {
        this.billWay = billWay;
    }

    public String getBillAccount() {
        return billAccount;
    }

    public void setBillAccount(String billAccount) {
        this.billAccount = billAccount;
    }

    public Timestamp getBillTime() {
        return billTime;
    }

    public void setBillTime(Timestamp billTime) {
        this.billTime = billTime;
    }
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375

    public String getBillYard() {
        return billYard;
    }

    public void setBillYard(String billYard) {
        this.billYard = billYard;
    }
}
