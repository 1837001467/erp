package com.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.entity.QxDepartment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Mapper
public interface QxDepartmentMapper  extends BaseMapper<QxDepartment> {
    //部门查询
    List<QxDepartment> qxbm(String seach);
    //部门去重
    List<QxDepartment> bmqc(String bmName);
//    新增部门
    @Insert("insert into qx_department values (0,#{bmName})")
    int insertbm(String bmName);
//    修改部门
    @Update("update qx_department set  bm_name=#{bmName} where bm_id=#{bmId}" )
    public void  updBm(Integer bmId,String bmName);
}
