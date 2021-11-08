package com.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class CgStorage implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer stId;

    private String stCode;

    private String stExplain;

    private String stAccount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp stTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp stSptime;

    private String stSpopinon;

    private Integer stState;

    private BigDecimal stTotalmoney;

    private QxUser qxUser;//采购员
    private JcSupplier jcSupplier;//供应商
    private QxUser sppeo;//审批人
    private JcWhinformation ck;//仓库

    private List<JcGoods> goods;

    public CgStorage() {
    }

    public CgStorage(Integer stId, String stCode, String stExplain, String stAccount, Timestamp stTime, Timestamp stSptime, String stSpopinon, Integer stState, BigDecimal stTotalmoney) {
        this.stId = stId;
        this.stCode = stCode;
        this.stExplain = stExplain;
        this.stAccount = stAccount;
        this.stTime = stTime;
        this.stSptime = stSptime;
        this.stSpopinon = stSpopinon;
        this.stState = stState;
        this.stTotalmoney = stTotalmoney;
    }

    public Integer getStId() {
        return stId;
    }

    public void setStId(Integer stId) {
        this.stId = stId;
    }

    public String getStCode() {
        return stCode;
    }

    public void setStCode(String stCode) {
        this.stCode = stCode;
    }

    public String getStExplain() {
        return stExplain;
    }

    public void setStExplain(String stExplain) {
        this.stExplain = stExplain;
    }

    public String getStAccount() {
        return stAccount;
    }

    public void setStAccount(String stAccount) {
        this.stAccount = stAccount;
    }

    public Timestamp getStTime() {
        return stTime;
    }

    public void setStTime(Timestamp stTime) {
        this.stTime = stTime;
    }

    public Timestamp getStSptime() {
        return stSptime;
    }

    public void setStSptime(Timestamp stSptime) {
        this.stSptime = stSptime;
    }

    public String getStSpopinon() {
        return stSpopinon;
    }

    public void setStSpopinon(String stSpopinon) {
        this.stSpopinon = stSpopinon;
    }

    public Integer getStState() {
        return stState;
    }

    public void setStState(Integer stState) {
        this.stState = stState;
    }

    public BigDecimal getStTotalmoney() {
        return stTotalmoney;
    }

    public void setStTotalmoney(BigDecimal stTotalmoney) {
        this.stTotalmoney = stTotalmoney;
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

    public QxUser getSppeo() {
        return sppeo;
    }

    public void setSppeo(QxUser sppeo) {
        this.sppeo = sppeo;
    }

    public JcWhinformation getCk() {
        return ck;
    }

    public void setCk(JcWhinformation ck) {
        this.ck = ck;
    }

    @Override
    public String toString() {
        return "CgStorage{" +
                "stId=" + stId +
                ", stCode='" + stCode + '\'' +
                ", stExplain='" + stExplain + '\'' +
                ", stAccount='" + stAccount + '\'' +
                ", stTime=" + stTime +
                ", stSptime=" + stSptime +
                ", stSpopinon='" + stSpopinon + '\'' +
                ", stState=" + stState +
                ", stTotalmoney=" + stTotalmoney +
                '}';
    }
}
