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
public class XsProceeds implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer proceedsId;

    private Integer yhId;

    private Integer khId;

    private Integer salesId;

    private Integer qxYhId;

    private String proceedsYard;

    private String proceedsWay;

    private String proceedsAccount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Timestamp proceedsTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Timestamp proceedsTimes;

    private String proceedsState;

    private BigDecimal proceedsMoney;

    private String proceedsName;

    private String orderYard;

    private String yonghuName;

    public String getYonghuName() {
        return yonghuName;
    }

    public void setYonghuName(String yonghuName) {
        this.yonghuName = yonghuName;
    }

    public String getProceedsName() {
        return proceedsName;
    }

    public void setProceedsName(String proceedsName) {
        this.proceedsName = proceedsName;
    }

    public String getOrderYard() {
        return orderYard;
    }

    public void setOrderYard(String orderYard) {
        this.orderYard = orderYard;
    }

    public BigDecimal getProceedsMoney() {
        return proceedsMoney;
    }

    public void setProceedsMoney(BigDecimal proceedsMoney) {
        this.proceedsMoney = proceedsMoney;
    }

    public XsProceeds() {
    }

    public XsProceeds(Integer proceedsId, Integer yhId, Integer khId, Integer salesId, Integer qxYhId, String proceedsYard, String proceedsWay, String proceedsAccount, Timestamp proceedsTime, Timestamp proceedsTimes, String proceedsState) {
        this.proceedsId = proceedsId;
        this.yhId = yhId;
        this.khId = khId;
        this.salesId = salesId;
        this.qxYhId = qxYhId;
        this.proceedsYard = proceedsYard;
        this.proceedsWay = proceedsWay;
        this.proceedsAccount = proceedsAccount;
        this.proceedsTime = proceedsTime;
        this.proceedsTimes = proceedsTimes;
        this.proceedsState = proceedsState;
    }



    @Override
    public String toString() {
        return "XsProceeds{" +
                "proceedsId=" + proceedsId +
                ", yhId=" + yhId +
                ", khId=" + khId +
                ", salesId=" + salesId +
                ", qxYhId=" + qxYhId +
                ", proceedsYard='" + proceedsYard + '\'' +
                ", proceedsWay='" + proceedsWay + '\'' +
                ", proceedsAccount='" + proceedsAccount + '\'' +
                ", proceedsTime=" + proceedsTime +
                ", proceedsTimes=" + proceedsTimes +
                ", proceedsState='" + proceedsState + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getProceedsId() {
        return proceedsId;
    }

    public void setProceedsId(Integer proceedsId) {
        this.proceedsId = proceedsId;
    }

    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public Integer getKhId() {
        return khId;
    }

    public void setKhId(Integer khId) {
        this.khId = khId;
    }

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public Integer getQxYhId() {
        return qxYhId;
    }

    public void setQxYhId(Integer qxYhId) {
        this.qxYhId = qxYhId;
    }

    public String getProceedsYard() {
        return proceedsYard;
    }

    public void setProceedsYard(String proceedsYard) {
        this.proceedsYard = proceedsYard;
    }

    public String getProceedsWay() {
        return proceedsWay;
    }

    public void setProceedsWay(String proceedsWay) {
        this.proceedsWay = proceedsWay;
    }

    public String getProceedsAccount() {
        return proceedsAccount;
    }

    public void setProceedsAccount(String proceedsAccount) {
        this.proceedsAccount = proceedsAccount;
    }

    public Timestamp getProceedsTime() {
        return proceedsTime;
    }

    public void setProceedsTime(Timestamp proceedsTime) {
        this.proceedsTime = proceedsTime;
    }

    public Timestamp getProceedsTimes() {
        return proceedsTimes;
    }

    public void setProceedsTimes(Timestamp proceedsTimes) {
        this.proceedsTimes = proceedsTimes;
    }

    public String getProceedsState() {
        return proceedsState;
    }

    public void setProceedsState(String proceedsState) {
        this.proceedsState = proceedsState;
    }
}
