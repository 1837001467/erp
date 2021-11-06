package com.study.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class XsBill implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer billId;

    private Integer returnId;

    private Integer khId;

    private Integer yhId;

    private Integer salesId;

    private BigDecimal billMoney;

    private String billWay;

    private String billAccount;

    private LocalDateTime billTime;


}
