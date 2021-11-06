package com.study.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class XsOrderdetails implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer detailsId;

    private Integer salesId;

    private Integer orderId;

    private Integer detailsNum;


}
