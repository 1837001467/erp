package com.study.service;

import com.study.entity.JcGoodsfen;
import com.study.mapper.JcGoodsfenMapper;
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
public class JcGoodsfenService{
    @Autowired
    JcGoodsfenMapper mapper;

    //所有分类
    public List<JcGoodsfen> selectAll(){
        return mapper.selectAll();
    }



}
