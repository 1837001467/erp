package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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

    private Integer goId;

    private Integer gfId;

    private String gName;

    private BigDecimal gPrice;

    private String gUnit;

    private Integer gBian;


}
