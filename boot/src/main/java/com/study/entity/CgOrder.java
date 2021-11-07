package com.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
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
public class CgOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Integer orId;

    private String orCode;

    private String orExplain;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp orTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp orSptime;

    private String orSpopinon;

    private Integer orState;

    private QxUser qxUser;//采购员
    private JcSupplier jcSupplier;//供应商
    private QxDepartment qxDepartment;//部门
    private QxUser sppeo;//审批人

    public CgOrder() {
    }

    public CgOrder(Integer orId, String orCode, String orExplain, Timestamp orTime, Timestamp orSptime, String orSpopinon, Integer orState) {
        this.orId = orId;
        this.orCode = orCode;
        this.orExplain = orExplain;
        this.orTime = orTime;
        this.orSptime = orSptime;
        this.orSpopinon = orSpopinon;
        this.orState = orState;
    }
}
