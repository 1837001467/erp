package com.study.service;

import com.study.entity.XsSalesorder;
import com.study.mapper.XsSalesorderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class XsSalesorderService{
    @Autowired private XsSalesorderMapper xsSalesorderMapper;
    //销售订单表多查询所有
    public List<XsSalesorder> selectAll(){
        return xsSalesorderMapper.selectAll();
    }
    //销售订单表多条件查询
    public List<XsSalesorder> selectById(XsSalesorder xsSalesorder){
        return xsSalesorderMapper.selectById(xsSalesorder);
    }
    //销售订单表新增
    public Integer addOrder(XsSalesorder xsSalesorder){
        return xsSalesorderMapper.addOrder(xsSalesorder);
    }
    //查询最大索引
    public Integer selectIdMax(){
        return xsSalesorderMapper.selectIdMax();
    }
}
