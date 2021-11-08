package com.study.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZcClaim implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer zcId;

    private QxDepartment bm;

    private QxUser yh;

    @JsonFormat(pattern = "yyyy-MM-dd hh:ss",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Timestamp zcApplicationtime;

    private String zcText;

    private JcWhinformation wh;

    private QxUser shen;

    @JsonFormat(pattern = "yyyy-MM-dd hh:ss",timezone="Asia/Shanghai")
    private Timestamp zcApprovaltime;

    private Integer zcState;

    private String zcBian;

    private String zcExplain;

}
