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
public class XsProceeds implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer proceedsId;

    private Integer yhId;

    private Integer khId;

    private Integer salesId;

    private Integer qxYhId;

    private String proceedsYard;

    private String proceedsWay;

    private String proceedsAccount;

    private LocalDateTime proceedsTime;

    private LocalDateTime proceedsTimes;

    private String proceedsState;


}
