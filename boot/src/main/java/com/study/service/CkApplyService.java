package com.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.entity.CkApply;
import com.study.entity.RkApply;
import com.study.mapper.CkApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
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
public class CkApplyService{
    @Autowired
    CkApplyMapper  ckApplyMapper;

    public PageInfo<CkApply> selectByPager(Integer no, Integer size){
        PageHelper.startPage(no,size);/*开启分页模式*/
        List<CkApply> list = ckApplyMapper.selectAll();/*调用mapper的查询方法*/
        return new PageInfo(list);/*将查询结果封装到PageInfo对象中并返回*/
    }


    public List<CkApply> lookDetails(Integer ckId) {
        return ckApplyMapper.selectById(ckId);
    }

    public Integer updateState(Integer ckId, Integer rkState, Integer yhId) {
      return  this.adopt( ckId,rkState,yhId,new Timestamp(System.currentTimeMillis()));  //修改入库申请的状态

    }
    public  Integer  adopt(Integer ckId,Integer yhId,Integer ckState ,Timestamp time){
      return  ckApplyMapper.update(ckId,ckState,yhId,time);
    }
}
