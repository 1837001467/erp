package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class JcCustomer implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer khId;

    private Integer cpId;

    private String khName;

    private String khTel;

    private String khAddress;

    private Integer khBian;

    private String khCity;

    private  Integer khStatus;

    public Integer getKhId() {
        return khId;
    }

    public void setKhId(Integer khId) {
        this.khId = khId;
    }

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public String getKhName() {
        return khName;
    }

    public void setKhName(String khName) {
        this.khName = khName;
    }

    public String getKhTel() {
        return khTel;
    }

    public void setKhTel(String khTel) {
        this.khTel = khTel;
    }

    public String getKhAddress() {
        return khAddress;
    }

    public void setKhAddress(String khAddress) {
        this.khAddress = khAddress;
    }

    public Integer getKhBian() {
        return khBian;
    }

    public void setKhBian(Integer khBian) {
        this.khBian = khBian;
    }

    public String getKhCity() {
        return khCity;
    }

    public void setKhCity(String khCity) {
        this.khCity = khCity;
    }

    public Integer getKhStatus() {
        return khStatus;
    }

    public void setKhStatus(Integer khStatus) {
        this.khStatus = khStatus;
    }
}
