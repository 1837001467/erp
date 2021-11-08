package com.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
public class CgReturn implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer reId;

    private Integer supId;

    /**
     * 采购员
     */
    private Integer yhId;

    /**
     * 退货仓
     */
    private Integer whId;

    /**
     * 审批人
     */
    private Integer spyhId;

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

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getSpyhId() {
        return spyhId;
    }

    public void setSpyhId(Integer spyhId) {
        this.spyhId = spyhId;
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
