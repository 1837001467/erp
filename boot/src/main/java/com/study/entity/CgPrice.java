package com.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
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
    private List<JcGoods> goods;

    public CgPrice() {
    }

    public CgPrice(Integer prId, String prCode, String prName, Timestamp prTime, BigDecimal prPrice, String prExplain, Timestamp prZdtime, Timestamp prSptime, String prSpopinon, Integer prState) {
        this.prId = prId;
        this.prCode = prCode;
        this.prName = prName;
        this.prTime = prTime;
        this.prPrice = prPrice;
        this.prExplain = prExplain;
        this.prZdtime = prZdtime;
        this.prSptime = prSptime;
        this.prSpopinon = prSpopinon;
        this.prState = prState;
    }
}
