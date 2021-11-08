package com.study.entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;

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
public class KcStock implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer kcId;

    private String kcBian;

    private Integer whId;

    private String kcType;

    private Integer gId;

    private Integer kcNum;


}
