package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.entity.JcWhinformation;
import com.study.service.JcWhinformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/JcWhinformation")
public class JcWhinformationController {
    @Autowired
    private JcWhinformationService jms;

    @GetMapping("selectAll")
    public List<JcWhinformation>  selectAll(){
        return jms.seleclAll();
    }

    @GetMapping("/pager")
    public PageInfo<JcWhinformation> selectAll(@RequestParam("no") Integer no,
                                               @RequestParam("size") Integer size,
                                               @RequestParam("find") String find){

        return jms.selectAll(no, size, find);
    }
}
