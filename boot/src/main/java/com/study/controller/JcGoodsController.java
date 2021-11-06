package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.entity.JcContactperson;
import com.study.entity.JcGoods;
import com.study.service.JcGoodsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class JcGoodsController {
    @Autowired
    private JcGoodsService es;
    @GetMapping("/pager")
    public PageInfo<JcGoods> selectAll(@RequestParam("no") Integer no,
                                       @RequestParam("size") Integer size,
                                       @RequestParam("find") String find){

        return es.selectAll(no, size, find);
    }

}
