package com.study.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class CgYinpay implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Integer yiId;

    private String yiAccount;

    private String yiType;

    private String yiWay;

    private BigDecimal yiPrice;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp yiTime;

    private Integer yiState;

    private JcSupplier supplier;
    private QxUser user;

    public CgYinpay() {
    }

    public CgYinpay(Integer yiId, String yiAccount, String yiType, String yiWay, BigDecimal yiPrice, Timestamp yiTime, Integer yiState) {
        this.yiId = yiId;
        this.yiAccount = yiAccount;
        this.yiType = yiType;
        this.yiWay = yiWay;
        this.yiPrice = yiPrice;
        this.yiTime = yiTime;
        this.yiState = yiState;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getYiId() {
        return yiId;
    }

    public void setYiId(Integer yiId) {
        this.yiId = yiId;
    }

    public String getYiAccount() {
        return yiAccount;
    }

    public void setYiAccount(String yiAccount) {
        this.yiAccount = yiAccount;
    }

    public String getYiType() {
        return yiType;
    }

    public void setYiType(String yiType) {
        this.yiType = yiType;
    }

    public String getYiWay() {
        return yiWay;
    }

    public void setYiWay(String yiWay) {
        this.yiWay = yiWay;
    }

    public BigDecimal getYiPrice() {
        return yiPrice;
    }

    public void setYiPrice(BigDecimal yiPrice) {
        this.yiPrice = yiPrice;
    }

    public Timestamp getYiTime() {
        return yiTime;
    }

    public void setYiTime(Timestamp yiTime) {
        this.yiTime = yiTime;
    }

    public Integer getYiState() {
        return yiState;
    }

    public void setYiState(Integer yiState) {
        this.yiState = yiState;
    }

    public JcSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(JcSupplier supplier) {
        this.supplier = supplier;
    }

    public QxUser getUser() {
        return user;
    }

    public void setUser(QxUser user) {
        this.user = user;
    }
}
