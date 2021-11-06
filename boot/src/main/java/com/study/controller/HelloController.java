package com.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 邱艳丽
 * @date 2021-10-21
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/")
    public String index(){
        return "hello";
    }
    @GetMapping("/hh")
    public void hh(){
        System.out.println("进入了hh()方法");
    }
}
