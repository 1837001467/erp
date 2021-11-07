package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
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
public class RkDetails implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer rkdId;

    private Integer gId;

    private Integer rkdNum;

    private Integer rkId;


}
