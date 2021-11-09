package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class CkDetails implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer ckdId;

    private JcGoods goods;

    private Integer ckdNum;

    private Integer ckId;

    public Integer getCkdId() {
        return ckdId;
    }

    public JcGoods getGoods() {
        return goods;
    }

    public void setGoods(JcGoods goods) {
        this.goods = goods;
    }

    public void setCkdId(Integer ckdId) {
        this.ckdId = ckdId;
    }



    public Integer getCkdNum() {
        return ckdNum;
    }

    public void setCkdNum(Integer ckdNum) {
        this.ckdNum = ckdNum;
    }

    public Integer getCkId() {
        return ckId;
    }

    public void setCkId(Integer ckId) {
        this.ckId = ckId;
    }
}
