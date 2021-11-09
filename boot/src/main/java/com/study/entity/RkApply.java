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
public class RkApply implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer rkId;

    private String rkBian;

    private String stCode;

    private QxUser yhshen;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Timestamp rkApplicationtime;

    private QxUser yhPi;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Timestamp rkApprovaltime;

    private String rkType;

    private Integer rkState;

    private String rkExplain;

    public Integer getRkId() {
        return rkId;
    }

    public void setRkId(Integer rkId) {
        this.rkId = rkId;
    }

    public String getRkBian() {
        return rkBian;
    }

    public void setRkBian(String rkBian) {
        this.rkBian = rkBian;
    }

    public String getStCode() {
        return stCode;
    }

    public void setStCode(String stCode) {
        this.stCode = stCode;
    }

    public QxUser getYhShen() {
        return yhshen;
    }

    public void setYhShen(QxUser yhShen) {
        this.yhshen = yhShen;
    }

    public Timestamp getRkApplicationtime() {
        return rkApplicationtime;
    }

    public void setRkApplicationtime(Timestamp rkApplicationtime) {
        this.rkApplicationtime = rkApplicationtime;
    }

    public QxUser getYhPi() {
        return yhPi;
    }

    public void setYhPi(QxUser yhPi) {
        this.yhPi = yhPi;
    }

    public Timestamp getRkApprovaltime() {
        return rkApprovaltime;
    }

    public void setRkApprovaltime(Timestamp rkApprovaltime) {
        this.rkApprovaltime = rkApprovaltime;
    }

    public String getRkType() {
        return rkType;
    }

    public void setRkType(String rkType) {
        this.rkType = rkType;
    }

    public Integer getRkState() {
        return rkState;
    }

    public void setRkState(Integer rkState) {
        this.rkState = rkState;
    }

    public String getRkExplain() {
        return rkExplain;
    }

    public void setRkExplain(String rkExplain) {
        this.rkExplain = rkExplain;
    }
}
