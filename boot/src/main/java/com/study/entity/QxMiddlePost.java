package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 职位权限中间表格
 * </p>
 *
 * @author 
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QxMiddlePost implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 职位id
     */
    private Integer posId;

    /**
     * 权限外键
     */
    private Integer jsdnId;


}
