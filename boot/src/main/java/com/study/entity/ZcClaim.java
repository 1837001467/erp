package com.study.entity;

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
public class ZcClaim implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "zc_id", type = IdType.AUTO)
    private Integer zcId;

    private Integer bmId;

    private Integer yhId;

    private LocalDateTime zcApplicationtime;

    private String zcText;

    private Integer whId;

    private Integer yhShen;

    private LocalDateTime zcApprovaltime;

    private Integer zcState;

    private String zcBian;

    private String zcExplain;


}
