package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QxDepartment implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 部门id
     */
    @Id
    private Integer bmId;

    /**
     * 部门名称
     */
    private String bmName;


}
