package com.study.vo;

import com.study.entity.JcSupplier;
import com.study.entity.QxDepartment;
import com.study.entity.QxUser;
import lombok.Data;

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
}
