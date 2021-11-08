package com.study.controller;


import com.study.entity.CgReturn;
import com.study.service.CgReturnService;
import com.study.vo.AddTuiHuo;
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
@RequestMapping("/cgReturn")
public class CgReturnController {
    @Autowired
    private CgReturnService service;

    @PostMapping("/all")
    public List<CgReturn> all(@RequestParam(value ="zt") Integer zt){
        return service.all(zt);
    }

    @PostMapping("/add")
    //新增
    public Integer add(@RequestBody AddTuiHuo vo){
        return  service.add(vo);
    }

    @PostMapping("/delTh")
    //删除退货单（修改状态）
    public Integer updateThState(@RequestParam(value = "reid") Integer reid, @RequestParam("restate") Integer restate) {
        return service.updateThState(reid, restate);
    }


    @PostMapping("/tuihuo")
    //退货操作
    public Integer tuihuo(@RequestParam(value = "code") String code){
        return service.tuihuo(code);
    }

}

