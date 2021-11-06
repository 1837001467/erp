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
 * @author 
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class XsSalesreturn implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer returnId;

    private Integer billId;

    private Integer yhId;

    private Integer qxYhId;

    private Integer khId;

    private Integer whId;

    private Integer salesId;

    private String returnType;

    private String returnAccount;

    private BigDecimal returnMoney;

    private String returnCause;

    private LocalDateTime returnTime;

    private LocalDateTime returnTimes;


}
