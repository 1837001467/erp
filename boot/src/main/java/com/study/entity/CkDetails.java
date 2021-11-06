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
public class CkDetails implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ckd_id", type = IdType.AUTO)
    private Integer ckdId;

    private Integer gId;

    private Integer ckdNum;

    private Integer ckId;


}
