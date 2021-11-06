package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>
 * 权限表格
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QxJsdn implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 权限id
     */
    @Id
    private Integer jsdnId;

    /**
     * 权限名称
     */
    private String jsdnName;

    /**
     * 组件名称
     */
    private String jsdnZname;

    /**
     * 组件路径
     */
    private String jsdnPath;

    /**
     * 图片路径
     */
    private String jsdnTpath;

    /**
     * 状态id
     */
    private Integer jsdnZt;

    /**
     * 自链接
     */
    private Integer jsdnZid;


}
