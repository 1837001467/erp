package com.study.controller;


import com.github.pagehelper.PageInfo;
import com.study.entity.CkApply;
import com.study.entity.RkApply;
import com.study.service.CkApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2021-11-06
 */
@RestController
@RequestMapping("/ckApply")
public class CkApplyController {
        @Autowired
    CkApplyService   cs;

    //分页查询所有的出库申请记录
    @RequestMapping("pager")
    public PageInfo<CkApply> selectByPager(@RequestParam(value = "no",defaultValue = "1") Integer pageNO,
                                           @RequestParam(value = "size",defaultValue = "5")Integer pageSize
    ){
        return cs.selectByPager(pageNO,pageSize);
    }

    //通过Id查看某条出库申请记录的详情
    @GetMapping("look")
    public List<CkApply> lookDailts(@RequestParam("rkId") Integer ckId){
        return cs.lookDetails(ckId);
    }

    //根据出库审批操作执行相应的操作
    @GetMapping("updateState")
    public  Integer  updaState(@RequestParam("ckId") Integer ckId,
                             @RequestParam("ckState") Integer  ckState,
                               @RequestParam("yhId") Integer yhId){
        return  cs.updateState(ckId, ckState, yhId);

    }
}

