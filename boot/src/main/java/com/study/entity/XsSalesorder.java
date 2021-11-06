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
public class XsSalesorder implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer orderId;

    private Integer yhId;

    private Integer salesId;

    private Integer khId;

    private Integer qxYhId;

    private String orderYard;

    private String orderName;

    private LocalDateTime goodsTime;

    private String orderSite;

    private String orderGoods;

    private String orderLinkman;

    private String orderPhone;

    private BigDecimal orderMoney;

    private LocalDateTime orderTime;

    private LocalDateTime orderTimes;

    private String orderState;


}
