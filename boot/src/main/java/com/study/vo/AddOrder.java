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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp xqtime;
    private Integer state;
    private String prname;
    private BigDecimal totalmoney;
}
