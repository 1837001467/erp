package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class JcSupplier implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Integer supId;

    private String supName;

    private String supTel;

    private Integer supBian;

    private Integer supStatus;

    private JcContactperson jcContactperson;//联系人


}
