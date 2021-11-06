package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>
 * 员工用户表
 * </p>
 *
 * @author 
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QxUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @Id
    private Integer yhId;

    /**
     * 用户账号
     */
    private String yhCard;

    /**
     * 用户名
     */
    private String yhName;

    /**
     * 用户密码
     */
    private String yhPswd;

    /**
     * 手机号
     */
    private String yhPhone;

    /**
     * 角色id
     */
    private Integer posId;

    /**
     * 用户状态
     */
    private Integer yhState;


}
