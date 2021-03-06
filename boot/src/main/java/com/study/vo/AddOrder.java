package com.study.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.entity.JcSupplier;
import com.study.entity.QxDepartment;
import com.study.entity.QxUser;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author 邱艳丽
 * @date 2021-11-07
 */
@Data
public class AddOrder {
    private QxUser user;
    private JcSupplier gys;
    private QxDepartment bm;
    private String ddcode;
    private String explain;
    private Integer prid;
    private GoodsArr[] tableData;

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

    public Integer getPrid() {
        return prid;
    }

    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    public GoodsArr[] getTableData() {
        return tableData;
    }

    public void setTableData(GoodsArr[] tableData) {
        this.tableData = tableData;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp xqtime;
    private Integer state;
    private String prname;
    private BigDecimal totalmoney;

    public Timestamp getXqtime() {
        return xqtime;
    }

    public void setXqtime(Timestamp xqtime) {
        this.xqtime = xqtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPrname() {
        return prname;
    }

    public void setPrname(String prname) {
        this.prname = prname;
    }

    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }
}
