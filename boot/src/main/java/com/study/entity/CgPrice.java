package com.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

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
public class CgPrice implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer prId;

    /**
     * 报价编码
     */
    private String prCode;

    /**
     * 项目名称
     */
    private String prName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp prTime;

    private BigDecimal prPrice;

    private String prExplain;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp prZdtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp prSptime;

    private String prSpopinon;

    private Integer prState;

    private QxUser qxUser;//经手人
    private JcSupplier jcSupplier;//供应商
    private QxDepartment qxDepartment;//部门
    private QxUser sppeo;//审批人


}
