package com.study.entity;

import java.io.Serializable;
import java.util.List;

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
public class XsOrderdetails implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer detailsId;

    private Integer salesId;

    private Integer orderId;

    private Integer detailsNum;

    private Integer goId;

    public XsOrderdetails() {
    }

    public XsOrderdetails(Integer detailsId, Integer salesId, Integer orderId, Integer detailsNum, Integer goId) {
        this.detailsId = detailsId;
        this.salesId = salesId;
        this.orderId = orderId;
        this.detailsNum = detailsNum;
        this.goId = goId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getDetailsNum() {
        return detailsNum;
    }

    public void setDetailsNum(Integer detailsNum) {
        this.detailsNum = detailsNum;
    }

    public Integer getGoId() {
        return goId;
    }

    public void setGoId(Integer goId) {
        this.goId = goId;
    }
}
