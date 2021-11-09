package com.study.controller;


import com.study.entity.CgYinpay;
import com.study.service.CgYinpayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
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
@RequestMapping("/yinpay")
public class CgYinpayController {
    @Autowired
    CgYinpayService service;

    //查询所有
    @GetMapping("/all")
    public List<CgYinpay> all(){
        return service.all();
    }

    //付款操作
    @PostMapping("/fukuan")
<<<<<<< HEAD
    public Integer fukuan(@RequestParam("yiid") Integer yiid, @RequestParam("way") String way, @RequestParam("fktype") String fktype, @RequestParam(value = "totalmoney")BigDecimal totalmoney){
        return service.fukuan(yiid,way,fktype,totalmoney);
=======
    public Integer fukuan(@RequestParam("yiid") Integer yiid, @RequestParam("way") String way, @RequestParam("fktype") String fktype){
        return service.fukuan(yiid,way,fktype);
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
    }




}

