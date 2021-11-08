package com.study.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 邱艳丽
 * @date 2021-11-07
 */
@Data
public class GoodsArr {
    private Integer goId;
    private Integer gfId;
    private String gName;
    private BigDecimal gPrice;
    private String gUnit;
    private Integer gBian;
}
