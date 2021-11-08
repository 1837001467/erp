package com.study.controller;

import com.alibaba.fastjson.JSON;
import com.study.entity.*;
import com.study.service.QxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

//权限Controller
@RestController
@CrossOrigin
public class QxController {
    @Autowired
    QxService qx;//权限
    //部门模糊查询
    @RequestMapping("qxbm")
    public List<QxDepartment> qxDe(String seach){
        return  qx.selcbm(seach);
    }
    //日志模糊查询
    @RequestMapping("rzcx")
    public List<QxLog> logCx(String seach){
        return  qx.selcrz(seach);
    }
    //查询角色权限
    @RequestMapping("jsqx")
    public List<QxJsdn> selcJsdnj(Integer posId){
        return qx.selcJsdnj(posId);
    }
    //查询用户权限
    @RequestMapping("dlqx")
    public List<QxJsdn> selcJsdnuser(Integer yhId){
        return qx.selcJsdnuser(yhId);
    }
    //查询用户权限
    @RequestMapping("syqx")
    public List<QxJsdn> scldq(){
        return qx.selactq();
    }
    //角色模糊查询
    @RequestMapping("action")
    public List<QxPost> jsCx(String seach){
        return  qx.selcjs(seach);
    }
    //用户模糊查询
    @RequestMapping("user")
    public List<QxUser> seletUser(String seach){
        return  qx.selcUser(seach);
    }
    //新增日志
    @RequestMapping("add-rz")
    public int addlist(@RequestBody QxLog log){
        return qx.addlist(log);
    }
    //新增修改部门
//    @RequestMapping("add-bm")
//    public boolean addlist(@RequestBody String bm){
//        System.out.println(bm);
//        Map map = JSON.parseObject(bm,Map.class);//将病房对象字符串转换为病房对象
//        QxDepartment proj = JSON.parseObject(map.get("proj").toString(), QxDepartment.class);
//        qx.bmUpdate(proj);
//    }
    //新增修改角色
    @PostMapping("add-js")
    public boolean addlist(@RequestBody QxPost js){
        return qx.jsUpdate(js);
    }
    //新增修改用户
    @PostMapping("adu-yh")
    public boolean addlist(@RequestBody QxUser yh){
        return qx.yhUpdate(yh);
    }
    //重置密码
    @PostMapping("upd-yhps")
    public String addlist11(@RequestBody QxUser xx){
        return qx.updUserpsw(xx.getYhId(),xx.getYhPswd());
    }
    //    登录
    @PostMapping("/login")
    public Object login(@RequestBody QxUser user, HttpSession session){
        QxUser info = qx.login(user);
        if(info != null){
            return info;
        }else{
            return "fail";
        }
    }
}
