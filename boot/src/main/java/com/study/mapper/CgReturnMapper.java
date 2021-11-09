package com.study.mapper;

import com.study.entity.CgReturn;
import com.study.entity.CgTicket;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-11-06
 */
@Mapper
public interface CgReturnMapper{
    List<CgReturn> selectAll(Integer zt);//查询所有采购退货

    Integer addTh(CgReturn cgReturn);//新增采购退货

    Integer updateTh(CgReturn cgReturn);//修改采购退货


}
