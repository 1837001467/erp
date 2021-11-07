package com.study.controller;

import com.study.entity.*;
import com.study.service.QxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("add-rz")
    public int addlist(@RequestBody QxLog log){
        return qx.addlist(log);
    }
    //新增日志
    @PostMapping("upd-yhps")
    public String addlist(@RequestBody Integer yhId,String yhPswd){
        return qx.updUserpsw(yhId,yhPswd);
    }
}
