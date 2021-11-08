package com.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class CgStorage implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer stId;

    private String stCode;

    private String stExplain;

    private String stAccount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp stTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp stSptime;

    private String stSpopinon;

    private Integer stState;

    private BigDecimal stTotalmoney;

    private QxUser qxUser;//采购员
    private JcSupplier jcSupplier;//供应商
    private QxUser sppeo;//审批人
    private JcWhinformation ck;//仓库

    private List<JcGoods> goods;

    public CgStorage() {
    }

    public CgStorage(Integer stId, String stCode, String stExplain, String stAccount, Timestamp stTime, Timestamp stSptime, String stSpopinon, Integer stState, BigDecimal stTotalmoney) {
        this.stId = stId;
        this.stCode = stCode;
        this.stExplain = stExplain;
        this.stAccount = stAccount;
        this.stTime = stTime;
        this.stSptime = stSptime;
        this.stSpopinon = stSpopinon;
        this.stState = stState;
        this.stTotalmoney = stTotalmoney;
    }
}
