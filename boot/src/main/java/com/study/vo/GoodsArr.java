package com.study.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 邱艳丽
 * @date 2021-11-07
 */
@Data
public class GoodsArr {
    private Integer goId;
    private Integer gfId;
    private String gName;
    private BigDecimal gPrice;
    private String gUnit;
    private Integer gBian;

    public Integer getGoId() {
        return goId;
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


}
