package com.study.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Timestamp receiptTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Timestamp receiptTimes;

    private String receiptState;


}
