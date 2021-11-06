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
public class XsReceipt implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer receiptId;

    private Integer yhId;

    private Integer qxYhId;

    private String receiptYary;

    private BigDecimal receiptMoney;

    private String receiptType;

    private String receiptAcount;

    private LocalDateTime receiptTime;

    private LocalDateTime receiptTimes;

    private String receiptState;


}
