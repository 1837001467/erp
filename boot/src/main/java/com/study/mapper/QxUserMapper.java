package com.study.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.entity.QxUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工用户表 Mapper 接口
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Mapper
public interface QxUserMapper extends BaseMapper<QxUser> {
    List<QxUser> selectUser(String seach);
    //重置密码
    @Update("update qz_user set yh_pswd=#{yhPswd} where yh_id=#{yhId}")
    public void  updUserPswd(Integer yhId,String yhPswd);
    QxUser selectCgZg();//查找采购主管
}
