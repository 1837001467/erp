package com.study.controller;


import com.study.entity.XsSalesorder;
import com.study.service.XsSalesorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@RestController
@RequestMapping("/study/xsSalesorder")
public class XsSalesorderController {
    @Autowired private XsSalesorderService xsSalesorderService;
    //销售订单表多查询所有
    @GetMapping
    public List<XsSalesorder> selectAll(){
        return xsSalesorderService.selectAll();
    }
    //销售订单表多条件查询
    @PostMapping
    public List<XsSalesorder> selectById(@RequestBody XsSalesorder xsSalesorder){
        return xsSalesorderService.selectById(xsSalesorder);
    }
    @PostMapping("/add")
    public void addOrder(@RequestBody XsSalesorder xsSalesorder){
        System.out.println("xxx");
        System.out.println("xxxx"+xsSalesorder);
//        Integer i = xsSalesorderService.addOrder(xsSalesorder);
//        if (i>0){
//            System.out.println("销售订单表新增成功");
//        }else{
//            System.out.println("销售订单表新增失败");
//        }
    }
}

