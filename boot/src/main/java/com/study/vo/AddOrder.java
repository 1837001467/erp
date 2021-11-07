package com.study.vo;

import lombok.Data;

/**
 * @author 邱艳丽
 * @date 2021-11-07
 */
@Data
public class AddOrder {
    private Integer cgyid;
    private Integer gys;
    private Integer cgbm;
    private String ddcode;
    private String explain;
    private GoodsArr[] tableData;
}
