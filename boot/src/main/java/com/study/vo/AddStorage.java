package com.study.vo;

import com.study.entity.JcSupplier;
import com.study.entity.JcWhinformation;
import com.study.entity.QxDepartment;
import com.study.entity.QxUser;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 邱艳丽
 * @date 2021-11-07
 */
@Data
public class AddStorage {
    private QxUser user;
    private JcSupplier gys;
    private QxDepartment bm;
    private String ddcode;
    private String explain;
    private JcWhinformation ck;
    private Integer orid;
    private GoodsArr[] tableData;
    private String zh;
    private BigDecimal totalmoney;



    public QxUser getUser() {
        return user;
    }

    public void setUser(QxUser user) {
        this.user = user;
    }

    public JcSupplier getGys() {
        return gys;
    }

    public void setGys(JcSupplier gys) {
        this.gys = gys;
    }

    public QxDepartment getBm() {
        return bm;
    }

    public void setBm(QxDepartment bm) {
        this.bm = bm;
    }

    public String getDdcode() {
        return ddcode;
    }

    public void setDdcode(String ddcode) {
        this.ddcode = ddcode;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public JcWhinformation getCk() {
        return ck;
    }

    public void setCk(JcWhinformation ck) {
        this.ck = ck;
    }

    public Integer getOrid() {
        return orid;
    }

    public void setOrid(Integer orid) {
        this.orid = orid;
    }

    public GoodsArr[] getTableData() {
        return tableData;
    }

    public void setTableData(GoodsArr[] tableData) {
        this.tableData = tableData;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }
    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
