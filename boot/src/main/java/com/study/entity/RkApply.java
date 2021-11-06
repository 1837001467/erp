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
public class RkApply implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "rk_id", type = IdType.AUTO)
    private Integer rkId;

    private String rkBian;

    private String stCode;

    private Integer yhShen;

    private LocalDateTime rkApplicationtime;

    private Integer yhPi;

    private LocalDateTime rkApprovaltime;

    private String rkType;

    private Integer rkState;

    private String rkExplain;


}
