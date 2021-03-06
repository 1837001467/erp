package com.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.entity.JcGoods;
import com.study.mapper.JcGoodsMapper;
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
public class JcGoodsService{
    @Autowired
    JcGoodsMapper mapper;
    
    //查找所有（分页）
    public PageInfo<JcGoods> selectAll(Integer no, Integer size, String find) {
        PageHelper.startPage(no,size);
        List<JcGoods> list = mapper.selectAll(no,size,find);
        return new PageInfo(list) ;
    }

    //根据商品类别找商品
    public List<JcGoods> selectByTypeId(Integer gfid){
        System.out.println("gfid="+gfid);
        return mapper.selectByTypeId(gfid);
    }

    //查找所有商品
    public List<JcGoods> selectOwn() {
        return  mapper.selectOwn();
    }
}
