package com.study.vo;

import com.study.entity.JcGoods;
import com.study.entity.JcWhinformation;
import com.study.entity.QxDepartment;
import com.study.entity.QxUser;
import lombok.Data;

public class ZcClaimVo {
    private QxUser user;
    private Integer   lyNum;
    private String    zcText;
    private QxDepartment  bm;
    private JcWhinformation  cangku;
    private JcGoods    commodity;

    @Override
    public String toString() {
        return "ZcClaimVo{" +
                "user=" + user +
                ", lyNum=" + lyNum +
                ", zcText='" + zcText + '\'' +
                ", bm=" + bm +
                ", Warehouse=" + cangku +
                ", commodity=" + commodity +
                '}';
    }

    public QxUser getUser() {
        return user;
    }

    public void setUser(QxUser user) {
        this.user = user;
    }

    public Integer getLyNum() {
        return lyNum;
    }

    public void setLyNum(Integer lyNum) {
        this.lyNum = lyNum;
    }

    public String getZcText() {
        return zcText;
    }

    public void setZcText(String zcText) {
        this.zcText = zcText;
    }

    public QxDepartment getBm() {
        return bm;
    }

    public void setBm(QxDepartment bm) {
        this.bm = bm;
    }

    public JcWhinformation getCangku() {
        return cangku;
    }

    public void setCangku(JcWhinformation cangku) {
        this.cangku = cangku;
    }

    public JcGoods getCommodity() {
        return commodity;
    }

    public void setCommodity(JcGoods commodity) {
        this.commodity = commodity;
    }
}
