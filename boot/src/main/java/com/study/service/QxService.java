package com.study.service;

import com.study.entity.QxDepartment;
import com.study.entity.QxLog;
import com.study.entity.QxPost;
import com.study.entity.QxUser;
import com.study.mapper.QxDepartmentMapper;
import com.study.mapper.QxLogMapper;
import com.study.mapper.QxPostMapper;
import com.study.mapper.QxUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    QxUserMapper user;//角色mapper
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

    //查询角色模糊查询
    public List<QxUser> selcUser(String seach){
        List<QxUser> listsp = user.selectUser(seach);
        return listsp;
    }


}
