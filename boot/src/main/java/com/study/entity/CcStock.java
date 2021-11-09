package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

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
public class CcStock implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer ccId;

    private Integer whId;

    private Integer gId;

    private Integer ccNum;

<<<<<<< HEAD
    public Integer getCcId() {
        return ccId;
    }

=======
    private JcGoods goods;

    public Integer getCcId() {
        return ccId;
    }

>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
    public void setCcId(Integer ccId) {
        this.ccId = ccId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Integer getCcNum() {
        return ccNum;
    }

    public void setCcNum(Integer ccNum) {
        this.ccNum = ccNum;
    }
<<<<<<< HEAD
=======

    public JcGoods getGoods() {
        return goods;
    }

    public void setGoods(JcGoods goods) {
        this.goods = goods;
    }
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
}
