package com.study.controller;


import com.study.entity.XsBill;
import com.study.service.XsBillService;
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
@RequestMapping("/study/xsBill")
public class XsBillController {
    @Autowired private XsBillService xsBillService;
    @GetMapping
    public List<XsBill> selectAll(){
        return xsBillService.selectAll();
    }
}

