package com.study.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class CgYinpay implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer yiId;

    private Integer yhId;

    private Integer supId;

    private String yiAccount;

    private String yiType;

    private String yiWay;

    private BigDecimal yiPrice;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp yiTime;

    private Integer yiState;


}
