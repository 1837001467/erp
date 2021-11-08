package com.study.vo;

import lombok.Data;

/**
 * @author 邱艳丽
 * @date 2021-11-06
 */
@Data
public class SearchOrderAndPage {
    private String ordercode;
    private Integer size;
    private Integer no;

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }
}
