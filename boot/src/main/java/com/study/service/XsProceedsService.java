package com.study.service;

import com.study.entity.XsProceeds;
import com.study.mapper.XsProceedsMapper;
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
public class XsProceedsService{
    @Autowired private XsProceedsMapper xsProceedsMapper;
    //新增收款单
    public Integer addProceeds(XsProceeds xsProceeds){
        return xsProceedsMapper.addProceeds(xsProceeds);
    }
    //收款单查询所有
    public List<XsProceeds> selectAll(){
        return xsProceedsMapper.selectAll();
    }
    //收款单审核
    public Integer updateProceeds(String proceedsState, Integer qxYhId, Integer proceedsId){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        if(proceedsState.equals("已申请")){
            xsProceedsMapper.updateProceeds("已审核",qxYhId,proceedsId,time);
        }
        return 1;
    }
}
