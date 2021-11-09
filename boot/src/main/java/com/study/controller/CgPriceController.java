package com.study.controller;


import com.github.pagehelper.PageInfo;
import com.study.entity.CgOrder;
import com.study.entity.CgPrice;
import com.study.service.CgPriceService;
import com.study.vo.AddOrder;
import com.study.vo.SearchOrderAndPage;
import com.study.vo.SearchPriceByPager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.text.ParseException;
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
@RequestMapping("/study/cgPrice")
public class CgPriceController {

    @Autowired
    CgPriceService service;

    //查询带条件分页
    @PostMapping("selectByPager")
    public PageInfo<CgPrice> selectByPager(@RequestBody SearchPriceByPager vo) throws ParseException {
        System.out.println("实体---------------------------："+vo);
        return service.SearchPriceByPager(vo);
    }

    //审批采购报价
    @PostMapping("examine")
    public Integer examine(@RequestParam(value = "prid") Integer prid,
                           @RequestParam(value = "spidea") String spidea,
                           @RequestParam(value = "applystate") String applystate){
        return service.examine(prid,spidea,applystate);
    }

    //新增
    @PostMapping("/add")
    public Integer add(@RequestBody AddOrder vo){
        return  service.add(vo);
    }

}

