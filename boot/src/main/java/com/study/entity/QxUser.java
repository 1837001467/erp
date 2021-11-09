package com.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @author zzl
 * @since 2021-11-06
 */
@Data
public class QxUser {
    /**
     * 用户id
     */
    @TableId(value = "yh_id",type = IdType.AUTO)
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

    /**
     * 角色
     */
    @TableField(exist = false)
    private QxPost ybm;
    /**
     * 部门
     */
    @TableField(exist = false)
    private QxDepartment bm;

<<<<<<< HEAD
=======
    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public String getYhCard() {
        return yhCard;
    }

    public void setYhCard(String yhCard) {
        this.yhCard = yhCard;
    }

    public String getYhName() {
        return yhName;
    }

    public void setYhName(String yhName) {
        this.yhName = yhName;
    }

    public String getYhPswd() {
        return yhPswd;
    }

    public void setYhPswd(String yhPswd) {
        this.yhPswd = yhPswd;
    }

    public String getYhPhone() {
        return yhPhone;
    }

    public void setYhPhone(String yhPhone) {
        this.yhPhone = yhPhone;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public Integer getYhState() {
        return yhState;
    }

    public void setYhState(Integer yhState) {
        this.yhState = yhState;
    }

    public QxPost getYbm() {
        return ybm;
    }

    public void setYbm(QxPost ybm) {
        this.ybm = ybm;
    }

    public QxDepartment getBm() {
        return bm;
    }

    public void setBm(QxDepartment bm) {
        this.bm = bm;
    }
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
}
