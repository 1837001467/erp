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
public class CgReturn implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Integer reId;

    private String reCode;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp reTime;

    /**
     * 退货理由
     */
    private String reResaon;

    /**
     * 审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp reSptime;

    /**
     * 审批意见
     */
    private String reSpopinon;

    /**
     * 状态
     */
    private Integer reState;



    public Integer getReId() {
        return reId;
    }

    private JcSupplier supplier;
    private JcWhinformation ck;//仓库
    private QxUser user;//采购员
    private List<JcGoods> goods;

    public JcSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(JcSupplier supplier) {
        this.supplier = supplier;
    }

    public JcWhinformation getCk() {
        return ck;
    }

    public void setCk(JcWhinformation ck) {
        this.ck = ck;
    }

    public QxUser getUser() {
        return user;
    }

    public void setUser(QxUser user) {
        this.user = user;
    }

    public List<JcGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<JcGoods> goods) {
        this.goods = goods;
    }

    public CgReturn() {
    }

    public CgReturn(Integer reId, String reCode, Timestamp reTime, String reResaon, Timestamp reSptime, String reSpopinon, Integer reState) {
        this.reId = reId;
        this.reCode = reCode;
        this.reTime = reTime;
        this.reResaon = reResaon;
        this.reSptime = reSptime;
        this.reSpopinon = reSpopinon;
        this.reState=reState;
    }

    public JcSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(JcSupplier supplier) {
        this.supplier = supplier;
    }

    public JcWhinformation getCk() {
        return ck;
    }

    public void setCk(JcWhinformation ck) {
        this.ck = ck;
    }

    public QxUser getUser() {
        return user;
    }

    public void setUser(QxUser user) {
        this.user = user;
    }

    public List<JcGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<JcGoods> goods) {
        this.goods = goods;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }
    public String getReCode() {
        return reCode;
    }

    public void setReCode(String reCode) {
        this.reCode = reCode;
    }

    public Timestamp getReTime() {
        return reTime;
    }

    public void setReTime(Timestamp reTime) {
        this.reTime = reTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getReResaon() {
        return reResaon;
    }

    public void setReResaon(String reResaon) {
        this.reResaon = reResaon;
    }

    public Timestamp getReSptime() {
        return reSptime;
    }

    public void setReSptime(Timestamp reSptime) {
        this.reSptime = reSptime;
    }

    public String getReSpopinon() {
        return reSpopinon;
    }

    public void setReSpopinon(String reSpopinon) {
        this.reSpopinon = reSpopinon;
    }

    public Integer getReState() {
        return reState;
    }

    public void setReState(Integer reState) {
        this.reState = reState;
    }
}
