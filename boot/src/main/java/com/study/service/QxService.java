package com.study.service;

import com.study.entity.*;
import com.study.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QxService {
    @Autowired
    QxDepartmentMapper bm;//部门mapper
    @Autowired
    QxLogMapper rz;//日志mapper
    @Autowired
    QxPostMapper js;//角色mapper
    @Autowired
    QxUserMapper ss;//角色mapper
    @Autowired
    QxJsdnMapper jsdn;//权限mapper
    //查询部门模糊查询
    public List<QxDepartment> selcbm(String seach){
        List<QxDepartment> listsp = bm.qxbm(seach);
        return listsp;
    }

    //查询日志模糊查询
    public List<QxLog> selcrz(String seach){
        List<QxLog> listsp = rz.rzcx(seach);
        return listsp;
    }
    //新增日志语句
    public int addlist(QxLog ss){
        int addlist =rz.insert(ss);
        if(addlist>0){
            return 1;
        }else{
            return 0;
        }
    }
    //查询角色模糊查询
    public List<QxPost> selcjs(String seach){
        List<QxPost> listsp = js.pstcx(seach);
        return listsp;
    }
    //登录

    public QxUser login(QxUser user){
     return ss.login(user);
    }
    //查询用户模糊查询
    public List<QxUser> selcUser(String seach){
        return ss.selectUser(seach);
    }
    //查询角色权限
    public List<QxJsdn> selcJsdnj(Integer posId){
        List<QxJsdn> listsp = jsdn.sqcx(posId);
        return listsp;
    }
    //查询用户权限
    public List<QxJsdn> selcJsdnuser(Integer yhId){
        List<QxJsdn> listsp = jsdn.dlqx(yhId);
        return listsp;
    }
    //查询权限
    public List<QxJsdn> selactq(){
        List<QxJsdn> listsp = jsdn.sycx();
        return listsp;
    }
    /**
     * 新增修改部门
     * @return
     */
    public void bmUpdate(Long bmId,String bmName){
            System.out.println(bmName);
            bm.insertbm(bmId,bmName);
    }
    /**
     * 新增修改角色
     * @return
     */
    public boolean jsUpdate(QxPost proj){
        int is = 0;//判断是否新增成功
        if(proj.getPosId() == 0){//新增
            js.insert(proj);
        }else{//修改
            is = js.updateById(proj);
        }
        return is == 0?false:true;
    }


    /**
     * 新增修改用户
     * @return
     */
    public boolean yhUpdate(QxUser proj){
        int is = 0;//判断是否新增成功
        if(proj.getYhId() == 0){//新增
            ss.insert(proj);
        }else{//修改
            is = ss.updateById(proj);
        }
        return is == 0?false:true;
    }
    //重置密码
    public String updUserpsw(Integer yhId,String yhPswd){
        try {
            ss.updUserPswd(yhId,yhPswd);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


}
