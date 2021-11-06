package com.study.controller;



import com.study.entity.CgOrder;
import com.study.service.CgOrderService;
import com.study.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@RestController
@RequestMapping("/study/cgOrder")
public class CgOrderController {
    MyResult myResult=new MyResult();
    @Autowired
    CgOrderService service;

    @PostMapping("allcgorder")
    public List<CgOrder> selectAllorder(){
        System.out.println("进入selectAllorder");
        List<CgOrder> list=service.selectlist();
        return  list;
    }


}

