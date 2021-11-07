package com.study.controller;


import com.github.pagehelper.PageInfo;
import com.study.entity.LyDetails;
import com.study.entity.ZcClaim;
import com.study.service.KcStockService;
import com.study.service.ZcClaimService;
import com.study.vo.ZcClaimVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/zcClaim")
public class ZcClaimController {
    @Autowired
    private ZcClaimService zs;
    //分页查询所有领用记录
    @RequestMapping("pager")
    public PageInfo<ZcClaim> selectByPager(@RequestParam(value = "no",defaultValue = "1") Integer pageNO,
                                           @RequestParam(value = "size",defaultValue = "5")Integer pageSize
                                        ){
        return zs.selectByPager(pageNO,pageSize);
    }

    //修改领用记录状态
    @GetMapping("update")
    public Integer  update(@RequestParam("zcId") Integer zxId,
                           @RequestParam("zcState")Integer zxState){
        return zs.update(zxId, zxState);
    }

    //通过Id查看某条领用记录的详情
    @GetMapping("look")
    public List<LyDetails> lookDailts(@RequestParam("zcId") Integer zxId){
        return zs.lookDetails(zxId);
    }

    //新增领用记录
    @PostMapping("add")
    public  Integer  add(@RequestBody ZcClaimVo vo){
        return zs.add(vo);
    }
}

