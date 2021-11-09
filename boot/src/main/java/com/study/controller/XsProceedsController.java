package com.study.controller;


import com.study.entity.XsProceeds;
import com.study.service.XsProceedsService;
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
@RequestMapping("/study/xsProceeds")
public class XsProceedsController {
    @Autowired private XsProceedsService xsProceedsService;
    //查询所有收款单
    @GetMapping
    public List<XsProceeds> selectAll(){
        return xsProceedsService.selectAll();
    }
    //收款单审核
    @PostMapping("update")
    public void updateProceeds(@RequestBody XsProceeds xsProceeds){
        System.out.println("开始修改收款单");
<<<<<<< HEAD
        xsProceedsService.updateProceeds(xsProceeds.getProceedsState(),xsProceeds.getQxYhId(),xsProceeds.getProceedsId());
=======
        xsProceedsService.updateProceeds(xsProceeds.getProceedsState(),xsProceeds.getQxYhId(),xsProceeds.getProceedsId(),xsProceeds);
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
    }
}

