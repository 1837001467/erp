package com.study.controller;



import com.github.pagehelper.PageInfo;
import com.study.entity.CgOrder;
import com.study.service.CgOrderService;
import com.study.utils.MyResult;
import com.study.vo.AddOrder;
import com.study.vo.SearchOrderAndPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.text.ParseException;
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

    @PostMapping("selectByPager")
    public PageInfo<CgOrder> selectByPager(@RequestBody SearchOrderAndPage vo) throws ParseException {
        System.out.println("实体---------------------------："+vo);
        return service.selectByPager(vo);
    }

    @PostMapping("addorder")//新增订单
    public Integer addorder(@RequestBody AddOrder vo){
        return service.addorder(vo);
    }

    //审批采购报价
    @PostMapping("examine")
    public Integer examine(@RequestParam(value = "orid") Integer orid,
                           @RequestParam(value = "spidea") String spidea,
                           @RequestParam(value = "applystate") String applystate){
        return service.examine(orid,spidea,applystate);
    }


}

