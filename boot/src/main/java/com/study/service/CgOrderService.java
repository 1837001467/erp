package com.study.service;

import com.study.entity.CgOrder;
import com.study.mapper.CgOrderMapper;
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
public class CgOrderService {
    @Autowired
    CgOrderMapper mapper;
    public List<CgOrder> selectlist(){
        return mapper.list();
    }

}
