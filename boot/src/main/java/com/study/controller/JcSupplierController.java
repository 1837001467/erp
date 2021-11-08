package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.entity.JcSupplier;
import com.study.service.JcSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/pager")
    public List<JcSupplier> selectAll(){

        return service.selectAll();
    }
    @PostMapping("/update")
    public Integer update(@RequestBody JcSupplier supfrom){
        Integer boo = service.save(supfrom);
        return boo;
    }
}
