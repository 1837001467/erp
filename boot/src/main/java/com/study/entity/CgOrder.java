package com.study.entity;

import java.time.LocalDateTime;
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
public class CgOrder implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer orId;

    private Integer supId;

    private Integer yhId;

    private Integer bmId;

    private Integer spyhId;

    private String orCode;

    private String orExplain;

    private LocalDateTime orTime;

    private LocalDateTime orSptime;

    private String orSpopinon;

    private Integer orState;


}
