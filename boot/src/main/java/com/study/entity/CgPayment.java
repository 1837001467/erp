package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

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

    private Timestamp paTime;

    private Timestamp paSptime;

    private String paSpopinon;

    private Integer paState;


}
