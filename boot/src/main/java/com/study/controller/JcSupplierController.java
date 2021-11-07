package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.entity.JcSupplier;
import com.study.service.JcSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 邱艳丽
 * @date 2021-11-07
 */
@RestController
@RequestMapping("/supplier")
public class JcSupplierController {
    @Autowired
    JcSupplierService service;

    @PostMapping("allsup")
    public List<JcSupplier> allSuppliers(){
        return service.allSuppliers();
    }

    @GetMapping("/pager")
    public PageInfo<JcSupplier> selectAll(@RequestParam("no") Integer no,
                                          @RequestParam("size") Integer size,
                                          @RequestParam("find") String find){

        return service.selectAll(no, size, find);
    }


}
