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
<<<<<<< HEAD
    QxUserMapper ss;//角色mapper
=======
    QxUserMapper ss;//用户mapper
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
    @Autowired
    QxJsdnMapper jsdn;//权限mapper
    @Autowired
    QxMiddlePostMapper middle;//角色权限中间表mapper
    //查询部门模糊查询
    public List<QxDepartment> selcbm(String seach){
        List<QxDepartment> listsp = bm.qxbm(seach);
        return listsp;
    }
    //查询部门去重
    public List<QxDepartment> bmqc(String bmName){
        List<QxDepartment> listsp = bm.bmqc(bmName);
        return listsp;
    }
    //查询角色去重
    public List<QxPost> jsqc(String posName){
        List<QxPost> listsp = js.selectPosq(posName);
        return listsp;
    }
    //查询用户去重
    public Integer yhqc(String yhCard){
        List<QxUser> listsp = ss.selectUserq(yhCard);
        if (listsp.size()==0){
            return 0;
        }else {
            return 1;
        }
    }
    //查询日志模糊查询
    public List<QxLog> selcrz(String seach){
        List<QxLog> listsp = rz.rzcx(seach);
        return listsp;
    }
    //新增日志语句
    public String addLog(QxLog log){
        System.out.println(log);
        try {
            rz.addLog(log);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
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
<<<<<<< HEAD
    public void bmUpdate(Long bmId,String bmName){
            System.out.println(bmName);
            bm.insertbm(bmId,bmName);
=======
    public String bmUpdate(Integer bmId,String bmName){
            System.out.println(bmId);
        try {
            if(bmId!=null){
                bm.updBm(bmId,bmName);
            }else {
                bm.insertbm(bmName);
            }
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
    }
    /**
     * 新增修改角色
     * @return
     */
    public String jsUpdate(QxPost pos){
        int is = 0;//判断是否新增成功
        System.out.println(pos);
        try {
            if(pos.getPosId() == null){//新增
                is = js.addPostq(pos);
                pos.getQxAn();
                System.out.println("新增编号"+pos.getPosId());
                middle.insertMiddle(pos.getPosId(),pos.getQxAn());
            }else{//修改
                middle.delet(pos.getPosId());
                middle.insertMiddle(pos.getPosId(),pos.getQxAn());
                is = js.updatePostq(pos);
            }
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    /**
     * 新增修改用户
     * @return
     */
    public String yhUpdate(QxUser user){
        int is = 0;//判断是否新增成功
<<<<<<< HEAD
        if(proj.getYhId() == 0){//新增
            ss.insert(proj);
        }else{//修改
            is = ss.updateById(proj);
=======
        System.out.println(user);
        try {
            if(user.getYhId() == null){//新增
                is = ss.addUser(user);
            }else{//修改
                is = ss.updateUser(user);
            }
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        }
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
