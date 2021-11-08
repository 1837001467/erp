package com.study.vo;

import lombok.Data;

/**
 * @author 邱艳丽
 * @date 2021-11-06
 */
@Data
public class SearchPriceByPager {
    private String xmname;
    private Integer cgbm;
    private Integer jsr;
    private Integer size;
    private Integer no;

    public String getXmname() {
        return xmname;
    }

    public void setXmname(String xmname) {
        this.xmname = xmname;
    }

    public Integer getCgbm() {
        return cgbm;
    }

    public void setCgbm(Integer cgbm) {
        this.cgbm = cgbm;
    }

    public Integer getJsr() {
        return jsr;
    }

    public void setJsr(Integer jsr) {
        this.jsr = jsr;
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
