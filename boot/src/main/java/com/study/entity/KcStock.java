package com.study.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;

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
public class KcStock implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer kcId;

    private String kcBian;

    private JcWhinformation wh;

    private String kcType;

    private JcGoods goods;

    private Integer kcNum;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Timestamp  kcTime;

    private  QxUser  user;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public QxUser getUser() {
        return user;
    }

    public void setUser(QxUser user) {
        this.user = user;
    }

    public Integer getKcId() {
        return kcId;
    }

    public void setKcId(Integer kcId) {
        this.kcId = kcId;
    }

    public String getKcBian() {
        return kcBian;
    }

    public void setKcBian(String kcBian) {
        this.kcBian = kcBian;
    }

    public JcWhinformation getWh() {
        return wh;
    }

    public void setWh(JcWhinformation wh) {
        this.wh = wh;
    }

    public String getKcType() {
        return kcType;
    }

    public void setKcType(String kcType) {
        this.kcType = kcType;
    }

    public JcGoods getGoods() {
        return goods;
    }

    public void setGoods(JcGoods goods) {
        this.goods = goods;
    }

    public Integer getKcNum() {
        return kcNum;
    }

    public void setKcNum(Integer kcNum) {
        this.kcNum = kcNum;
    }

    public Timestamp getKcTime() {
        return kcTime;
    }

    public void setKcTime(Timestamp kcTime) {
        this.kcTime = kcTime;
    }
}
