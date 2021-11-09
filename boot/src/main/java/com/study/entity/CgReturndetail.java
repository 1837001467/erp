package com.study.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class CgReturndetail implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer rdId;

    private Integer rdCount;

    private BigDecimal rdPrice;

    public CgReturndetail() {
    }

    public CgReturndetail(Integer rdId, Integer rdCount, BigDecimal rdPrice) {
        this.rdId = rdId;
        this.rdCount = rdCount;
        this.rdPrice = rdPrice;
    }

    private JcGoods goods;
    private CgReturn cgReturn;

    public Integer getRdId() {
        return rdId;
    }

    public void setRdId(Integer rdId) {
        this.rdId = rdId;
    }

    public Integer getRdCount() {
        return rdCount;
    }

    public void setRdCount(Integer rdCount) {
        this.rdCount = rdCount;
    }

    public BigDecimal getRdPrice() {
        return rdPrice;
    }

    public void setRdPrice(BigDecimal rdPrice) {
        this.rdPrice = rdPrice;
    }

    public JcGoods getGoods() {
        return goods;
    }

    public void setGoods(JcGoods goods) {
        this.goods = goods;
    }

    public CgReturn getCgReturn() {
        return cgReturn;
    }

    public void setCgReturn(CgReturn cgReturn) {
        this.cgReturn = cgReturn;
    }
}
