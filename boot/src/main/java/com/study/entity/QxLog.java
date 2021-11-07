package com.study.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 日志表
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QxLog implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 日志主键
     */
    @Id
    private Integer logId;

    /**
     * 操作动作
     */
    private String logAction;

    /**
     * 用户id
     */
    private Integer yhId;

    /**
     * 操作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private LocalDateTime logTime;
    //用户
    @TableField(exist = false)
    private QxUser yh;
}
