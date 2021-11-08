package com.study.service;

import com.study.entity.CgReturn;
import com.study.mapper.CgReturnMapper;
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
public class CgReturnService{
    @Autowired
    CgReturnMapper mapper;

    public List<CgReturn> all(){
        return mapper.all();
    }



}
