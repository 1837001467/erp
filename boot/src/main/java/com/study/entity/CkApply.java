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
public class CkApply implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ck_id", type = IdType.AUTO)
    private Integer ckId;

    private String ckBian;

    private String salesYard;

    private Integer yhShen;

    private LocalDateTime ckApplicationtime;

    private Integer yhPi;

    private LocalDateTime ckApprovaltime;

    private String ckType;

    private Integer ckState;

    private String ckExplain;


}
