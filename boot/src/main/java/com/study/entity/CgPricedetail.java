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
public class CgPricedetail implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer pdId;

    private Integer gId;

    private Integer prId;

    private Integer pdCount;

    private BigDecimal pdPrice;


}
