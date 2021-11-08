package com.study.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class CgReturndetail implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer rdId;

    private Integer rdCount;

    private BigDecimal rdPrice;

    public CgReturndetail() {
    }

    public CgReturndetail(Integer rdId, Integer rdCount, BigDecimal rdPrice) {
        this.rdId = rdId;
        this.rdCount = rdCount;
        this.rdPrice = rdPrice;
    }

    private JcGoods goods;
    private CgReturn cgReturn;
}
