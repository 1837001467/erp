package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>
 * 职位表
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QxPost implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 职位id
     */
    @Id
    private Integer posId;

    /**
     * 职位名
     */
    private String posName;

    /**
     * 部门id
     */
    private String bmId;


}
