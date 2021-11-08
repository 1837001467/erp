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
public class CgOrderdetail implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Integer odId;

    private Integer odCount;

    private BigDecimal odPrice;

    public CgOrderdetail() {
    }

    public CgOrderdetail(Integer odId, Integer odCount, BigDecimal odPrice) {
        this.odId = odId;
        this.odCount = odCount;
        this.odPrice = odPrice;
    }

    private CgOrder order;//订单
    private JcGoods goods;//商品

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public Integer getOdCount() {
        return odCount;
    }

    public void setOdCount(Integer odCount) {
        this.odCount = odCount;
    }

    public BigDecimal getOdPrice() {
        return odPrice;
    }

    public void setOdPrice(BigDecimal odPrice) {
        this.odPrice = odPrice;
    }

    public CgOrder getOrder() {
        return order;
    }

    public void setOrder(CgOrder order) {
        this.order = order;
    }

    public JcGoods getGoods() {
        return goods;
    }

    public void setGoods(JcGoods goods) {
        this.goods = goods;
    }
}
