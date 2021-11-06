package com.study.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

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
public class CgStorage implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Integer stId;

    private Integer supId;

    private Integer yhId;

    private Integer spyhId;

    private Integer whId;

    private String stCode;

    private String stExplain;

    private String stAccount;

    private LocalDateTime stTime;

    private LocalDateTime stSptime;

    private String stSpopinon;

    private Integer stState;


}
