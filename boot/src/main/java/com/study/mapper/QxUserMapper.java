package com.study.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.entity.QxPost;
import com.study.entity.QxUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
//    用户查询
    List<QxUser> selectUser(String seach);
    //去重查询
    @Select("select * from qx_user where yh_card=#{yhCard}")
    List<QxUser> selectUserq(String yhCard);
    //重置密码
    @Update("update qx_user set yh_pswd=#{yhPswd} where yh_id=#{yhId}")
    public void  updUserPswd(Integer yhId,String yhPswd);
    QxUser selectCgZg();//查找采购主管
    //登录
    public QxUser login(QxUser user);
<<<<<<< HEAD
=======
    Integer addUser(QxUser user);//新增用户
    Integer updateUser(QxUser user);//新增用户
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
}
