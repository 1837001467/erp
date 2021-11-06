package com.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class QxDepartment{
    /**
     * 部门id
     */
    @TableId(value = "bm_id",type = IdType.AUTO)
    private Long bmId;
    /**
     * 部门名称
     */
    private String bmName;


}
