package com.study.vo;

import com.study.entity.JcSupplier;
import com.study.entity.JcWhinformation;
import com.study.entity.QxUser;

import java.util.Arrays;

/**
 * @author 邱艳丽
 * @date 2021-11-08
 */
public class AddTuiHuo {
    private String ddcode;
    private QxUser user;
    private JcSupplier supplier;
    private JcWhinformation ck;
    private String explain;
    private GoodsArr[] tableData;

    public String getDdcode() {
        return ddcode;
    }

    public void setDdcode(String ddcode) {
        this.ddcode = ddcode;
    }

    public QxUser getUser() {
        return user;
    }

    public void setUser(QxUser user) {
        this.user = user;
    }

    public JcSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(JcSupplier supplier) {
        this.supplier = supplier;
    }

    public JcWhinformation getCk() {
        return ck;
    }

    public void setCk(JcWhinformation ck) {
        this.ck = ck;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public GoodsArr[] getTableData() {
        return tableData;
    }

    public void setTableData(GoodsArr[] tableData) {
        this.tableData = tableData;
    }



    @Override
    public String toString() {
        return "AddTuiHuo{" +
                "ddcode='" + ddcode + '\'' +
                ", user=" + user +
                ", supplier=" + supplier +
                ", ck=" + ck +
                ", explain='" + explain + '\'' +
                ", tableData=" + Arrays.toString(tableData) +
                '}';
    }
}
