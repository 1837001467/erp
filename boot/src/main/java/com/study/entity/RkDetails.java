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
public class RkDetails implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer rkdId;

    private JcGoods good;

    private Integer rkdNum;

    private Integer rkId;

    public Integer getRkdId() {
        return rkdId;
    }

    public void setRkdId(Integer rkdId) {
        this.rkdId = rkdId;
    }

    public JcGoods getGood() {
        return good;
    }

    public void setGood(JcGoods good) {
        this.good = good;
    }

    public Integer getRkdNum() {
        return rkdNum;
    }

    public void setRkdNum(Integer rkdNum) {
        this.rkdNum = rkdNum;
    }

    public Integer getRkId() {
        return rkId;
    }

    public void setRkId(Integer rkId) {
        this.rkId = rkId;
    }
}
