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
public class CgReturn implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Integer reId;

    private String reCode;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp reTime;

    /**
     * 退货理由
     */
    private String reResaon;

    /**
     * 审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp reSptime;

    /**
     * 审批意见
     */
    private String reSpopinon;

    /**
     * 状态
     */
    private Integer reState;

    private JcSupplier supplier;
    private JcWhinformation ck;//仓库
    private QxUser user;//采购员
    private List<JcGoods> goods;

    public CgReturn() {
    }

    public CgReturn(Integer reId, String reCode, Timestamp reTime, String reResaon, Timestamp reSptime, String reSpopinon, Integer reState) {
        this.reId = reId;
        this.reCode = reCode;
        this.reTime = reTime;
        this.reResaon = reResaon;
        this.reSptime = reSptime;
        this.reSpopinon = reSpopinon;
        this.reState = reState;
    }
}
