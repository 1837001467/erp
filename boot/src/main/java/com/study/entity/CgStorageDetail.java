package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author 邱艳丽
 * @date 2021-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CgStorageDetail {
    private static final long serialVersionUID=1L;

    private Integer sdId;

    private Integer sdCount;

    private BigDecimal sdPrice;

    private CgStorage cgStorage;//入库单
    private JcGoods goods;//商品

    public CgStorageDetail() {
    }

    public CgStorageDetail(Integer sdId, Integer sdCount, BigDecimal sdPrice) {
        this.sdId = sdId;
        this.sdCount = sdCount;
        this.sdPrice = sdPrice;
    }

    public Integer getSdCount() {
        return sdCount;
    }

    public void setSdCount(Integer sdCount) {
        this.sdCount = sdCount;
    }

    public BigDecimal getSdPrice() {
        return sdPrice;
    }

    public void setSdPrice(BigDecimal sdPrice) {
        this.sdPrice = sdPrice;
    }

    public JcGoods getGoods() {
        return goods;
    }

    public void setGoods(JcGoods goods) {
        this.goods = goods;
    }

    public CgStorage getCgStorage() {
        return cgStorage;
    }

    public void setCgStorage(CgStorage cgStorage) {
        this.cgStorage = cgStorage;
    }
}
