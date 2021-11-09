package com.study.entity;

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
public class XsSalesticket implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer salesId;

    private Integer yhId;

    private Integer proceedsId;

    private Integer whId;

    private Integer khId;

    private Integer returnId;

    private Integer qxYhId;

    private Integer billId;

    private String salesYard;

    private String salesAccount;

    private String salesWay;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Timestamp salesTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Timestamp salesTimes;

    private String salesState;

    private String goodsType;

    private Integer orderId;

    private Integer detailsId;
}
