package com.study.controller;


import com.study.entity.CgTicket;
import com.study.mapper.CgTicketMapper;
import com.study.service.CgTicketService;
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
@RequestMapping("/cgTicket")
public class CgTicketController {
    @Autowired
    CgTicketService service;

    @GetMapping("/all")//查询所有
    public List<CgTicket> all() {
        return service.all();
    }

    //删除收票（修改状态）
    @PostMapping("/delticket")
    public Integer updateTicket(@RequestParam(value = "tiid") Integer tiid, @RequestParam("tistate") Integer tistate) {
        return service.updateTicket(tiid, tistate);
    }
}

