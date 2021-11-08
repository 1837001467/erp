package com.study.controller;


import com.github.pagehelper.PageInfo;
import com.study.entity.LyDetails;
import com.study.entity.RkApply;
import com.study.entity.ZcClaim;
import com.study.service.RkApplyService;
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
@RequestMapping("/rkApply")
public class RkApplyController {
    @Autowired
    RkApplyService  rs;

    //分页查询所有入库申请记录
    @RequestMapping("pager")
    public PageInfo<RkApply> selectByPager(@RequestParam(value = "no",defaultValue = "1") Integer pageNO,
                                           @RequestParam(value = "size",defaultValue = "5")Integer pageSize
    ){
        return rs.selectByPager(pageNO,pageSize);
    }

    //通过Id查看某条入库申请记录的详情
    @GetMapping("look")
    public List<RkApply> lookDailts(@RequestParam("rkId") Integer rxId){
        return rs.lookDetails(rxId);
    }

    //根据不同的入库审批操作执行不同的操作
    @GetMapping("updateState")
    public  Integer  updaState(@RequestParam("rkId") Integer rxId,@RequestParam("stcode") String stCode,
                               @RequestParam("rkState") Integer  rkState,
                               @RequestParam("yhId") Integer yhId){
        rs.updateState(rxId, stCode, rkState,yhId);
        return null;
    }
    //采购入库
    @GetMapping("cgAdd")
    public  Integer  cgAdd(@RequestParam("stCode")String stCode){
        return rs.cgAdd(stCode);
    }
}

