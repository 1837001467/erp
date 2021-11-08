package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

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
public class CgPricedetail implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Integer pdId;

    private Integer pdCount;

    private BigDecimal pdPrice;

    private JcGoods goods;
    private CgPrice cgPrice;

    public CgPricedetail() {
    }

    public CgPricedetail(Integer pdId, Integer pdCount, BigDecimal pdPrice) {
        this.pdId = pdId;
        this.pdCount = pdCount;
        this.pdPrice = pdPrice;
    }

    public Integer getPdId() {
        return pdId;
    }

    public void setPdId(Integer pdId) {
        this.pdId = pdId;
    }

    public Integer getPdCount() {
        return pdCount;
    }

    public void setPdCount(Integer pdCount) {
        this.pdCount = pdCount;
    }

    public BigDecimal getPdPrice() {
        return pdPrice;
    }

    public void setPdPrice(BigDecimal pdPrice) {
        this.pdPrice = pdPrice;
    }

    public JcGoods getGoods() {
        return goods;
    }

    public void setGoods(JcGoods goods) {
        this.goods = goods;
    }

    public CgPrice getCgPrice() {
        return cgPrice;
    }

    public void setCgPrice(CgPrice cgPrice) {
        this.cgPrice = cgPrice;
    }
}
