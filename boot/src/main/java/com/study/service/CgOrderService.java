package com.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.entity.CgOrder;
import com.study.mapper.CgOrderMapper;
import com.study.vo.SearchOrderAndPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2021-11-06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CgOrderService {
    @Autowired
    CgOrderMapper mapper;
    public List<CgOrder> selectlist(){
        return mapper.list();
    }

    //分页条件查询
    public PageInfo<CgOrder> selectByPager(SearchOrderAndPage vo){
        System.out.println("service:"+vo);
        PageHelper.startPage(vo.getNo(),vo.getSize());/*开启分页模式*/
        List<CgOrder> list = mapper.searchByKeyword(vo);/*调用mapper的查询方法*/
        return new PageInfo(list);/*将查询结果封装到PageInfo对象中并返回*/
    }

}
