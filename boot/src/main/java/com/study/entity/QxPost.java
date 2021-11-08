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
}
