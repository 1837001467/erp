package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class JcSupplier implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer supId;

    private Integer cpId;

    private String supName;

    private String supTel;

    private Integer supBian;

    private Integer supStatus;


}
