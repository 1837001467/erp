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
public class XsReceipt implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer receiptId;

    private Integer yhId;

    private Integer qxYhId;

    private String receiptYary;

    private BigDecimal receiptMoney;

    private String receiptType;

    private String receiptAcount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Timestamp receiptTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Timestamp receiptTimes;
<<<<<<< HEAD
=======

    private String receiptState;

    private String khName;
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375

    private String orderYard;

    private Integer salesId;

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

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

    public XsReceipt() {
    }

    public XsReceipt(Integer receiptId, Integer yhId, Integer qxYhId, String receiptYary, BigDecimal receiptMoney, String receiptType, String receiptAcount, Timestamp receiptTime, Timestamp receiptTimes, String receiptState) {
        this.receiptId = receiptId;
        this.yhId = yhId;
        this.qxYhId = qxYhId;
        this.receiptYary = receiptYary;
        this.receiptMoney = receiptMoney;
        this.receiptType = receiptType;
        this.receiptAcount = receiptAcount;
        this.receiptTime = receiptTime;
        this.receiptTimes = receiptTimes;
        this.receiptState = receiptState;
    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Integer receiptId) {
        this.receiptId = receiptId;
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

    public String getReceiptYary() {
        return receiptYary;
    }

    public void setReceiptYary(String receiptYary) {
        this.receiptYary = receiptYary;
    }

    public BigDecimal getReceiptMoney() {
        return receiptMoney;
    }

    public void setReceiptMoney(BigDecimal receiptMoney) {
        this.receiptMoney = receiptMoney;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public String getReceiptAcount() {
        return receiptAcount;
    }

    public void setReceiptAcount(String receiptAcount) {
        this.receiptAcount = receiptAcount;
    }

    public Timestamp getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(Timestamp receiptTime) {
        this.receiptTime = receiptTime;
    }

    public Timestamp getReceiptTimes() {
        return receiptTimes;
    }

    public void setReceiptTimes(Timestamp receiptTimes) {
        this.receiptTimes = receiptTimes;
    }

    public String getReceiptState() {
        return receiptState;
    }

    public void setReceiptState(String receiptState) {
        this.receiptState = receiptState;
    }
}
