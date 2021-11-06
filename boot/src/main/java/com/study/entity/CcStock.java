package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import javax.persistence.*;

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
public class CcStock implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer ccId;

    private Integer whId;

    private Integer gId;

    private Integer ccNum;


}
