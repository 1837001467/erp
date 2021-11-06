package com.study.controller;

import com.study.entity.QxDepartment;
import com.study.entity.QxLog;
import com.study.entity.QxPost;
import com.study.entity.QxUser;
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
}
