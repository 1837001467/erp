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
public class JcWhinformation implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer whId;

    private String whName;

    private Integer whBian;

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public Integer getWhBian() {
        return whBian;
    }

    public void setWhBian(Integer whBian) {
        this.whBian = whBian;
    }
}
