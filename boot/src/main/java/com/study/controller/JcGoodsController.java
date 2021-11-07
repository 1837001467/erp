package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.entity.JcContactperson;
import com.study.entity.JcGoods;
import com.study.entity.JcGoodsfen;
import com.study.service.JcGoodsService;
import com.study.service.JcGoodsfenService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class JcGoodsController {
    @Autowired
    private JcGoodsService es;
    @Autowired
    private JcGoodsfenService jcGoodsfenService;

    @GetMapping("/pager")
    public PageInfo<JcGoods> selectAll(@RequestParam("no") Integer no,
                                       @RequestParam("size") Integer size,
                                       @RequestParam("find") String find){

        return es.selectAll(no, size, find);
    }


    @RequestMapping("alltype")//所有商品分类
    public List<JcGoodsfen> allType(){
        return  jcGoodsfenService.selectAll();
    }

    @RequestMapping("getByType")//根据分类找商品
    public List<JcGoods> getByType(@RequestParam(value = "gfId") Integer gfid){
        return es.selectByTypeId(gfid);
    }

    //查询所有的商品
    @GetMapping("/own")
    public List<JcGoods> selectOwn(){
        return es.selectOwn();
    }


}
