package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

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
public class JcGoods implements Serializable {

    private static final long serialVersionUID=1L;
    @Id
    private Integer goId;

    private Integer gfId;

    private String gName;

    private BigDecimal gPrice;

    private String gUnit;

    private Integer gBian;

    private Integer gStatus;

    private CgPricedetail cgPricedetail;//采购报价详情
    private CgOrderdetail cgOrderdetail;//采购订单详情
    private CgStorageDetail cgStorageDetail;//采购入库详情
    private CgReturndetail cgReturndetail;//采购退货详情

    public Integer getGoId() {
        return goId;
    }

    public CgPricedetail getCgPricedetail() {
        return cgPricedetail;
    }

    public void setCgPricedetail(CgPricedetail cgPricedetail) {
        this.cgPricedetail = cgPricedetail;
    }

    public CgOrderdetail getCgOrderdetail() {
        return cgOrderdetail;
    }

    public void setCgOrderdetail(CgOrderdetail cgOrderdetail) {
        this.cgOrderdetail = cgOrderdetail;
    }

    public CgStorageDetail getCgStorageDetail() {
        return cgStorageDetail;
    }

    public void setCgStorageDetail(CgStorageDetail cgStorageDetail) {
        this.cgStorageDetail = cgStorageDetail;
    }

    public CgReturndetail getCgReturndetail() {
        return cgReturndetail;
    }

    public void setCgReturndetail(CgReturndetail cgReturndetail) {
        this.cgReturndetail = cgReturndetail;
    }

    public void setGoId(Integer goId) {
        this.goId = goId;
    }

    public Integer getGfId() {
        return gfId;
    }

    public void setGfId(Integer gfId) {
        this.gfId = gfId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public BigDecimal getgPrice() {
        return gPrice;
    }

    public void setgPrice(BigDecimal gPrice) {
        this.gPrice = gPrice;
    }

    public String getgUnit() {
        return gUnit;
    }

    public void setgUnit(String gUnit) {
        this.gUnit = gUnit;
    }

    public Integer getgBian() {
        return gBian;
    }

    public void setgBian(Integer gBian) {
        this.gBian = gBian;
    }

    public Integer getgStatus() {
        return gStatus;
    }

    public void setgStatus(Integer gStatus) {
        this.gStatus = gStatus;
    }
}
