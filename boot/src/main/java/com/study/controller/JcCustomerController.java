package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.entity.JcContactperson;
import com.study.entity.JcCustomer;
import com.study.service.JcContactpersonService;
import com.study.service.JcCustomerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/study/jcCustomer")
public class JcCustomerController {
    @Autowired public JcCustomerService jcCustomerService;
    @GetMapping
    public List<JcCustomer> selectAll(){
        return jcCustomerService.selectAll();
    }

}
