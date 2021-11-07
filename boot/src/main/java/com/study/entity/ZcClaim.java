package com.study.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
public class ZcClaim implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Integer zcId;

    private QxDepartment bm;

    private QxUser yh;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Timestamp zcApplicationtime;

    private String zcText;

    private JcWhinformation wh;

    private QxUser shen;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Timestamp zcApprovaltime;

    private Integer zcState;

    private String zcBian;

    private String zcExplain;

    public ZcClaim() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getZcId() {
        return zcId;
    }

    public void setZcId(Integer zcId) {
        this.zcId = zcId;
    }

    public QxDepartment getBm() {
        return bm;
    }

    public void setBm(QxDepartment bm) {
        this.bm = bm;
    }

    public QxUser getYh() {
        return yh;
    }

    public void setYh(QxUser yh) {
        this.yh = yh;
    }

    public Timestamp getZcApplicationtime() {
        return zcApplicationtime;
    }

    public void setZcApplicationtime(Timestamp zcApplicationtime) {
        this.zcApplicationtime = zcApplicationtime;
    }

    public String getZcText() {
        return zcText;
    }

    public void setZcText(String zcText) {
        this.zcText = zcText;
    }

    public JcWhinformation getWh() {
        return wh;
    }

    public void setWh(JcWhinformation wh) {
        this.wh = wh;
    }

    public QxUser getShen() {
        return shen;
    }

    public void setShen(QxUser shen) {
        this.shen = shen;
    }

    public Timestamp getZcApprovaltime() {
        return zcApprovaltime;
    }

    public void setZcApprovaltime(Timestamp zcApprovaltime) {
        this.zcApprovaltime = zcApprovaltime;
    }

    public Integer getZcState() {
        return zcState;
    }

    public void setZcState(Integer zcState) {
        this.zcState = zcState;
    }

    public String getZcBian() {
        return zcBian;
    }

    public void setZcBian(String zcBian) {
        this.zcBian = zcBian;
    }

    public String getZcExplain() {
        return zcExplain;
    }

    public void setZcExplain(String zcExplain) {
        this.zcExplain = zcExplain;
    }
}
