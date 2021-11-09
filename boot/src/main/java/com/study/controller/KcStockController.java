package com.study.controller;


import com.github.pagehelper.PageInfo;
import com.study.entity.KcStock;
import com.study.entity.ZcClaim;
import com.study.service.KcStockService;
import com.study.service.ZcClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2021-11-06
 */
@RestController
@RequestMapping("/kcStock")
public class KcStockController {
    @Autowired
    private KcStockService ks;
    //分页查询所有库存变动
    @RequestMapping("pager")
    public PageInfo<KcStock> selectByPager(@RequestParam(value = "no",defaultValue = "1") Integer pageNO,
                                           @RequestParam(value = "size",defaultValue = "5")Integer pageSize,
                                           @RequestParam("kcBian")String kcBian
    ){
        return ks.selectByPager(pageNO,pageSize,kcBian);
    }

    //领用申请通过  库存变动
    @GetMapping("adopt")
    public Integer adopt(@RequestParam("zcId") Integer zcId,
                         @RequestParam("yuId")Integer yuId){

        return ks.update(zcId,yuId);
    }
}


