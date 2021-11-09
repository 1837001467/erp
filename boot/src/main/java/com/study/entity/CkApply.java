package com.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
public class CkApply implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer ckId;

    private String ckBian;

    private String salesYard;

    private QxUser yhShen;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Timestamp ckApplicationtime;

    private QxUser yhPi;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Timestamp ckApprovaltime;

    private String ckType;

    private Integer ckState;

    private String ckExplain;

    public Integer getCkId() {
        return ckId;
    }

    public void setCkId(Integer ckId) {
        this.ckId = ckId;
    }

    public String getCkBian() {
        return ckBian;
    }

    public void setCkBian(String ckBian) {
        this.ckBian = ckBian;
    }

    public String getSalesYard() {
        return salesYard;
    }

    public void setSalesYard(String salesYard) {
        this.salesYard = salesYard;
    }

    public QxUser getYhShen() {
        return yhShen;
    }

    public void setYhShen(QxUser yhShen) {
        this.yhShen = yhShen;
    }

    public Timestamp getCkApplicationtime() {
        return ckApplicationtime;
    }

    public void setCkApplicationtime(Timestamp ckApplicationtime) {
        this.ckApplicationtime = ckApplicationtime;
    }

    public QxUser getYhPi() {
        return yhPi;
    }

    public void setYhPi(QxUser yhPi) {
        this.yhPi = yhPi;
    }

    public Timestamp getCkApprovaltime() {
        return ckApprovaltime;
    }

    public void setCkApprovaltime(Timestamp ckApprovaltime) {
        this.ckApprovaltime = ckApprovaltime;
    }

    public String getCkType() {
        return ckType;
    }

    public void setCkType(String ckType) {
        this.ckType = ckType;
    }

    public Integer getCkState() {
        return ckState;
    }

    public void setCkState(Integer ckState) {
        this.ckState = ckState;
    }

    public String getCkExplain() {
        return ckExplain;
    }

    public void setCkExplain(String ckExplain) {
        this.ckExplain = ckExplain;
    }
}
