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
}
