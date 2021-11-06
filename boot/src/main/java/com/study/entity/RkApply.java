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
 * @author
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RkApply implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
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
