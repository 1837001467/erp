package com.study.controller;


import com.study.service.RkApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2021-11-06
 */
@RestController
@RequestMapping("/rkApply")
public class RkApplyController {
    @Autowired
    RkApplyService  rs;

    //采购入库
    public  Integer  cgAdd(String stCode){
        return rs.cgAdd(stCode);
    }
}

