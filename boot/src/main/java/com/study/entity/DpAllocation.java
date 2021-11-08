package com.study.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class DpAllocation implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer dpId;

    private String dpBian;

    private JcWhinformation whOut;

    private JcWhinformation whIn;

    private JcGoods gId;

    private Integer dpNum;

    private QxUser yhShen;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Timestamp pdApplicationtime;

    private QxUser yhPi;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Timestamp dpApprovaltime;

    private Integer dpState;

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }

    public String getDpBian() {
        return dpBian;
    }

    public void setDpBian(String dpBian) {
        this.dpBian = dpBian;
    }

    public JcWhinformation getWhOut() {
        return whOut;
    }

    public void setWhOut(JcWhinformation whOut) {
        this.whOut = whOut;
    }

    public JcWhinformation getWhIn() {
        return whIn;
    }

    public void setWhIn(JcWhinformation whIn) {
        this.whIn = whIn;
    }

    public JcGoods getgId() {
        return gId;
    }

    public void setgId(JcGoods gId) {
        this.gId = gId;
    }

    public Integer getDpNum() {
        return dpNum;
    }

    public void setDpNum(Integer dpNum) {
        this.dpNum = dpNum;
    }

    public QxUser getYhShen() {
        return yhShen;
    }

    public void setYhShen(QxUser yhShen) {
        this.yhShen = yhShen;
    }

    public Timestamp getPdApplicationtime() {
        return pdApplicationtime;
    }

    public void setPdApplicationtime(Timestamp pdApplicationtime) {
        this.pdApplicationtime = pdApplicationtime;
    }

    public QxUser getYhPi() {
        return yhPi;
    }

    public void setYhPi(QxUser yhPi) {
        this.yhPi = yhPi;
    }

    public Timestamp getDpApprovaltime() {
        return dpApprovaltime;
    }

    public void setDpApprovaltime(Timestamp dpApprovaltime) {
        this.dpApprovaltime = dpApprovaltime;
    }

    public Integer getDpState() {
        return dpState;
    }

    public void setDpState(Integer dpState) {
        this.dpState = dpState;
    }
}
