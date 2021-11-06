package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

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
public class CkApply implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
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
