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
public class CgReturn implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer reId;

    private Integer supId;

    /**
     * 采购员
     */
    private Integer yhId;

    /**
     * 退货仓
     */
    private Integer whId;

    /**
     * 审批人
     */
    private Integer spyhId;

    private String reCode;

    private LocalDateTime reTime;

    /**
     * 退货理由
     */
    private String reResaon;

    /**
     * 审批时间
     */
    private LocalDateTime reSptime;

    /**
     * 审批意见
     */
    private String reSpopinon;

    /**
     * 状态
     */
    private Integer reState;


}
