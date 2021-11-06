package com.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.entity.ZcClaim;
import com.study.mapper.ZcClaimMapper;
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
public class ZcClaimService{
       @Autowired
    ZcClaimMapper  mapper;

    public PageInfo<ZcClaim> selectByPager(Integer no, Integer size){
        PageHelper.startPage(no,size);/*开启分页模式*/
        List<ZcClaim> list = mapper.selectAll();/*调用mapper的查询方法*/
        return new PageInfo(list);/*将查询结果封装到PageInfo对象中并返回*/
    }

    public  Integer  update(Integer  zcId,Integer zcState){
        Integer  state = mapper.update(zcId, zcState);
        if(state !=1){
            return 0;
        }
        return  state;
    }
}
