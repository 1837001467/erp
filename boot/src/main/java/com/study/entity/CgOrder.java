package com.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

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
public class CgOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Integer orId;

    private String orCode;

    private String orExplain;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp orTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp orSptime;

    private String orSpopinon;

    private Integer orState;

    private QxUser qxUser;//采购员
    private JcSupplier jcSupplier;//供应商
    private QxDepartment qxDepartment;//部门
    private QxUser sppeo;//审批人
    private List<JcGoods> goods;

    public CgOrder() {
    }

    public CgOrder(Integer orId, String orCode, String orExplain, Timestamp orTime, Timestamp orSptime, String orSpopinon, Integer orState) {
        this.orId = orId;
        this.orCode = orCode;
        this.orExplain = orExplain;
        this.orTime = orTime;
        this.orSptime = orSptime;
        this.orSpopinon = orSpopinon;
        this.orState = orState;
    }

    public Integer getOrId() {
        return orId;
    }

    public void setOrId(Integer orId) {
        this.orId = orId;
    }

    public String getOrCode() {
        return orCode;
    }

    public void setOrCode(String orCode) {
        this.orCode = orCode;
    }

    public String getOrExplain() {
        return orExplain;
    }

    public void setOrExplain(String orExplain) {
        this.orExplain = orExplain;
    }

    public Timestamp getOrTime() {
        return orTime;
    }

    public void setOrTime(Timestamp orTime) {
        this.orTime = orTime;
    }

    public Timestamp getOrSptime() {
        return orSptime;
    }

    public void setOrSptime(Timestamp orSptime) {
        this.orSptime = orSptime;
    }

    public String getOrSpopinon() {
        return orSpopinon;
    }

    public void setOrSpopinon(String orSpopinon) {
        this.orSpopinon = orSpopinon;
    }

    public Integer getOrState() {
        return orState;
    }

    public void setOrState(Integer orState) {
        this.orState = orState;
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

    public List<JcGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<JcGoods> goods) {
        this.goods = goods;
    }
}
