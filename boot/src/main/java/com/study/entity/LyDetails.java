package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

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
public class LyDetails implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    private Integer lyId;

    private JcGoods goods;

    private Integer zcId;

    private Integer lyNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getLyId() {
        return lyId;
    }

    public void setLyId(Integer lyId) {
        this.lyId = lyId;
    }

    public JcGoods getGoods() {
        return goods;
    }

    public void setGoods(JcGoods goods) {
        this.goods = goods;
    }

    public Integer getZcId() {
        return zcId;
    }

    public void setZcId(Integer zcId) {
        this.zcId = zcId;
    }

    public Integer getLyNum() {
        return lyNum;
    }

    public void setLyNum(Integer lyNum) {
        this.lyNum = lyNum;
    }
}
