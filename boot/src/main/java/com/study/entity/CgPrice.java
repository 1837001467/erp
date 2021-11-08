package com.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
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
public class CgPrice implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer prId;

    /**
     * 报价编码
     */
    private String prCode;

    /**
     * 项目名称
     */
    private String prName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp prTime;

    private BigDecimal prPrice;

    private String prExplain;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp prZdtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp prSptime;

    private String prSpopinon;

    private Integer prState;

    private QxUser qxUser;//经手人
    private JcSupplier jcSupplier;//供应商
    private QxDepartment qxDepartment;//部门
    private QxUser sppeo;//审批人

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }

    public String getPrCode() {
        return prCode;
    }

    public void setPrCode(String prCode) {
        this.prCode = prCode;
    }

    public String getPrName() {
        return prName;
    }

    public void setPrName(String prName) {
        this.prName = prName;
    }

    public Timestamp getPrTime() {
        return prTime;
    }

    public void setPrTime(Timestamp prTime) {
        this.prTime = prTime;
    }

    public BigDecimal getPrPrice() {
        return prPrice;
    }

    public void setPrPrice(BigDecimal prPrice) {
        this.prPrice = prPrice;
    }

    public String getPrExplain() {
        return prExplain;
    }

    public void setPrExplain(String prExplain) {
        this.prExplain = prExplain;
    }

    public Timestamp getPrZdtime() {
        return prZdtime;
    }

    public void setPrZdtime(Timestamp prZdtime) {
        this.prZdtime = prZdtime;
    }

    public Timestamp getPrSptime() {
        return prSptime;
    }

    public void setPrSptime(Timestamp prSptime) {
        this.prSptime = prSptime;
    }

    public String getPrSpopinon() {
        return prSpopinon;
    }

    public void setPrSpopinon(String prSpopinon) {
        this.prSpopinon = prSpopinon;
    }

    public Integer getPrState() {
        return prState;
    }

    public void setPrState(Integer prState) {
        this.prState = prState;
    }

    public QxUser getQxUser() {
        return qxUser;
    }

    public void setQxUser(QxUser qxUser) {
        this.qxUser = qxUser;
    }

    public JcSupplier getJcSupplier() {
        return jcSupplier;
    }

    public void setJcSupplier(JcSupplier jcSupplier) {
        this.jcSupplier = jcSupplier;
    }

    public QxDepartment getQxDepartment() {
        return qxDepartment;
    }

    public void setQxDepartment(QxDepartment qxDepartment) {
        this.qxDepartment = qxDepartment;
    }

    public QxUser getSppeo() {
        return sppeo;
    }

    public void setSppeo(QxUser sppeo) {
        this.sppeo = sppeo;
    }
}
