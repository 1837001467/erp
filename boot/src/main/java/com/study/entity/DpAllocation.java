package com.study.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;

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
public class DpAllocation implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer dpId;

    private String dpBian;

    private Integer whOut;

    private Integer whIn;

    private Integer gId;

    private Integer dpNum;

    private Integer yhShen;

    private LocalDateTime pdApplicationtime;

    private Integer yhPi;

    private LocalDateTime dpApprovaltime;

    private Integer dpState;


}
