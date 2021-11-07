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
}
