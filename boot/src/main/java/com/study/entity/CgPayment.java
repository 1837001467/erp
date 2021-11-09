package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

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
public class CgPayment implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer paId;

    private Integer yhId;

    private Integer tiId;

    private Integer supId;

    private Integer spyhId;

    private String paCode;

    private String paAccount;

    private String paType;

    private String paWay;

    private BigDecimal paPrice;

    private Timestamp paTime;

    private Timestamp paSptime;

    private String paSpopinon;

    private Integer paState;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPaId() {
        return paId;
    }

    public void setPaId(Integer paId) {
        this.paId = paId;
    }

    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public Integer getTiId() {
        return tiId;
    }

    public void setTiId(Integer tiId) {
        this.tiId = tiId;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public Integer getSpyhId() {
        return spyhId;
    }

    public void setSpyhId(Integer spyhId) {
        this.spyhId = spyhId;
    }

    public String getPaCode() {
        return paCode;
    }

    public void setPaCode(String paCode) {
        this.paCode = paCode;
    }

    public String getPaAccount() {
        return paAccount;
    }

    public void setPaAccount(String paAccount) {
        this.paAccount = paAccount;
    }

    public String getPaType() {
        return paType;
    }

    public void setPaType(String paType) {
        this.paType = paType;
    }

    public String getPaWay() {
        return paWay;
    }

    public void setPaWay(String paWay) {
        this.paWay = paWay;
    }

    public BigDecimal getPaPrice() {
        return paPrice;
    }

    public void setPaPrice(BigDecimal paPrice) {
        this.paPrice = paPrice;
    }

    public Timestamp getPaTime() {
        return paTime;
    }

    public void setPaTime(Timestamp paTime) {
        this.paTime = paTime;
    }

    public Timestamp getPaSptime() {
        return paSptime;
    }

    public void setPaSptime(Timestamp paSptime) {
        this.paSptime = paSptime;
    }

    public String getPaSpopinon() {
        return paSpopinon;
    }

    public void setPaSpopinon(String paSpopinon) {
        this.paSpopinon = paSpopinon;
    }

    public Integer getPaState() {
        return paState;
    }

    public void setPaState(Integer paState) {
        this.paState = paState;
    }
}
