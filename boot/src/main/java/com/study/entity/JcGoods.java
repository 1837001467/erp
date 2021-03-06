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

}
