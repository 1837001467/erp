package com.study.controller;


import com.study.entity.XsSalesorder;
import com.study.service.XsSalesorderService;
import com.study.vo.XsOrderAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
    public void addOrder(@RequestBody XsOrderAll order){
        Integer i = xsSalesorderService.addOrder(order);
    }
    @PostMapping("/update")
    public void updateOrderSetState(@RequestBody XsSalesorder xsSalesorder){
        System.out.println("进入修改");
        xsSalesorderService.updateOrderSetState(xsSalesorder.getOrderState(),xsSalesorder.getQxYhId(),xsSalesorder.getOrderId());

    }
}

