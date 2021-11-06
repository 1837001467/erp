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
public class CgPayment implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer paId;

    private Integer yhId;

    private Integer tiId;

    private Integer supId;

    private Integer spyhId;

    private String paCode;

    private String paAccount;

    private String paType;

    private String paWay;

    private BigDecimal paPrice;

    private LocalDateTime paTime;

    private LocalDateTime paSptime;

    private String paSpopinon;

    private Integer paState;


}
