package com.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class KcStock implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "kc_id", type = IdType.AUTO)
    private Integer kcId;

    private String kcBian;

    private Integer whId;

    private String kcType;

    private Integer gId;

    private Integer kcNum;


}
