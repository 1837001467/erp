package com.study.controller;


import com.study.entity.CgReturn;
import com.study.service.CgReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/cgReturn")
public class CgReturnController {
    @Autowired
    private CgReturnService service;

    @GetMapping("/all")
    public List<CgReturn> all(){
        return service.all();
    }

}

