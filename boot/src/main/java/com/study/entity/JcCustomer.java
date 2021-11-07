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
 * @author 
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class JcCustomer implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer khId;

    private Integer cpId;

    private String khName;

    private String khTel;

    private String khAddress;

    private Integer khBian;

    private String khCity;

    private  Integer khStatus;


}
