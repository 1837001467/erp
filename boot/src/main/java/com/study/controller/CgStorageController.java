package com.study.controller;


import com.study.entity.CgStorage;
import com.study.service.CgStorageService;
import com.study.vo.AddOrder;
import com.study.vo.AddStorage;
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
@RequestMapping("/study/cgStorage")
public class CgStorageController {
    @Autowired
    CgStorageService service;

    @PostMapping("addstorage")//新增入库单
    public Integer addstorage(@RequestBody AddStorage vo){
        return service.addstorage(vo);
    }

    @GetMapping("/all")
    public List<CgStorage> all(){
        return service.all();
    }

    //审批采购报价
    @PostMapping("/examine")
    public Integer examine(@RequestParam(value = "stid") Integer stid,
                           @RequestParam(value = "spidea") String spidea,
                           @RequestParam(value = "applystate") String applystate){
        return service.examine(stid,spidea,applystate);
    }
}

