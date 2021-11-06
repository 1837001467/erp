package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

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
public class CgOrderdetail implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer odId;

    private Integer gId;

    private Integer orId;

    private Integer odCount;

    private BigDecimal odPrice;


}
