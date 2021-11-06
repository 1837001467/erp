package com.study.entity;

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

    private LocalDateTime salesTime;

    private LocalDateTime salesTimes;

    private String salesState;

    private String goodsType;


}
