package com.study.controller;


import com.github.pagehelper.PageInfo;
import com.study.entity.DpAllocation;
import com.study.entity.JcGoods;
import com.study.entity.ZcClaim;
import com.study.service.DpAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
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
@RequestMapping("/dpAllocation")
public class DpAllocationController {
    @Autowired
    private DpAllocationService ds;

    //分页查询所有领用记录
    @RequestMapping("pager")
    public PageInfo<DpAllocation> selectByPager(@RequestParam(value = "no",defaultValue = "1") Integer pageNO,
                                                @RequestParam(value = "size",defaultValue = "5")Integer pageSize
    ){
        return ds.selectByPager(pageNO,pageSize);
    }

    //根据不同的调拨审批操作执行不同的操作
    @GetMapping("updateState")
    public Integer  updateState(@RequestParam("dpBian") String dpBian,
                                @RequestParam("rkState")Integer rkState,
                                @RequestParam("yhId")Integer yhId){
        return ds.updateState(dpBian,rkState,yhId);
    }

    //查询仓库内拥有的所有商品
    @GetMapping("stock")
    public List<JcGoods> stock(@RequestParam("out")Integer out){
        return ds.selectByWhid(out);
    }

    //新增一条仓库调拨记录去审核
    @GetMapping("add")
    public Integer add(@RequestParam("outhouse")Integer outhouse,
                       @RequestParam("inhouse")Integer inhouse,
                       @RequestParam("num")Integer num,
                       @RequestParam("gid")Integer gid,
                       @RequestParam("yhid")Integer yhid){
      return ds.add(outhouse,inhouse,num,gid,yhid,new Timestamp(System.currentTimeMillis()),0);
    }

}

