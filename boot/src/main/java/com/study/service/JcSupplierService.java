package com.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.entity.JcSupplier;
import com.study.mapper.JcSupplierMapper;
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
public class JcSupplierService{
    @Autowired
    JcSupplierMapper mapper;

    public List<JcSupplier> allSuppliers(){
        return mapper.allSuppliers();
    }

    public PageInfo<JcSupplier> selectAll(Integer no, Integer size, String find) {
        PageHelper.startPage(no,size);
        List<JcSupplier> list = mapper.selectAll(no,size,find);

        return new PageInfo(list) ;
    }

}
