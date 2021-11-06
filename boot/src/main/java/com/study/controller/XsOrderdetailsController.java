package com.study.controller;


import com.study.entity.XsOrderdetails;
import com.study.service.XsOrderdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
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
@RequestMapping("/study/xsOrderdetails")
public class XsOrderdetailsController {
    @Autowired private XsOrderdetailsService xsOrderdetailsService;
    //根据销售订单id或销售单id查询订单详情表
    @GetMapping
    public List<XsOrderdetails> selectById(){
        Integer i = 111;
        Integer x = null;
        return xsOrderdetailsService.selectById(i,x);
    }
}

