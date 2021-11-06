package com.study.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class CgPrice implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "pr_id", type = IdType.AUTO)
    private Integer prId;

    /**
     * 经手人
     */
    private Integer yhId;

    /**
     * 审批人
     */
    private Integer spyhId;

    /**
     * 采购部门
     */
    private Integer bmId;

    private Integer supId;

    /**
     * 报价编码
     */
    private String prCode;

    /**
     * 项目名称
     */
    private String prName;

    private LocalDateTime prTime;

    private BigDecimal prPrice;

    private String prExplain;

    private LocalDateTime prZdtime;

    private LocalDateTime prSptime;

    private String prSpopinon;

    private Integer prState;


}
