package com.study.service.impl;

import com.study.entity.CgOrder;
import com.study.mapper.CgOrderMapper;
import com.study.service.CgOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Service
public class CgOrderServiceImpl extends ServiceImpl<CgOrderMapper, CgOrder> implements CgOrderService {
    @Autowired
    CgOrderMapper mapper;

    @Override
    public List<CgOrder> selectlist() {
        return mapper.list();
    }
}
