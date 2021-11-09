package com.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 职位表
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Data
public class QxPost{

    /**
     * 职位id
     */
    @TableId(value = "pos_id",type = IdType.AUTO)
    private Integer posId;

    /**
     * 职位名
     */
    private String posName;

    /**
     * 部门id
     */
    private Integer bmId;
    //部门
    @TableField(exist = false)
    private QxDepartment bm;
    //权限集合
    @TableField(exist = false)
    private List<Integer> qxAn;

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public Integer getBmId() {
        return bmId;
    }

    public void setBmId(Integer bmId) {
        this.bmId = bmId;
    }

    public QxDepartment getBm() {
        return bm;
    }

    public void setBm(QxDepartment bm) {
        this.bm = bm;
    }

    public List<Integer> getQxAn() {
        return qxAn;
    }

    public void setQxAn(List<Integer> qxAn) {
        this.qxAn = qxAn;
    }
}
