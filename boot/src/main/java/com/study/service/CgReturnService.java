package com.study.service;

import com.study.entity.*;
import com.study.mapper.CgReturnMapper;
import com.study.mapper.CgReturndetailMapper;
import com.study.mapper.CgStorageMapper;
import com.study.vo.AddTuiHuo;
import com.study.vo.GoodsArr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;
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
    @Autowired
    CgStorageMapper storageMapper;
    @Autowired
    CgReturndetailMapper cgReturndetailMapper;

    //修改退货单的状态
    public Integer updateThState(Integer reid,Integer restate){
        System.out.println("reid"+reid+"restate="+restate);
        CgReturn cgReturn=new CgReturn();
        cgReturn.setReId(reid);
        if(restate.equals(0)){
            cgReturn.setReState(1);
        }else{
            cgReturn.setReState(0);
        }
        return mapper.updateTh(cgReturn);
    }

    //查询所有采购退货单
    public List<CgReturn> all(Integer searchState){
        return mapper.selectAll(searchState);
    }



    //采购退货页面新增
    public Integer add(AddTuiHuo vo){
        System.out.println("进入add"+vo);
        Timestamp nowtime= new Timestamp(System.currentTimeMillis());
        CgReturn cgReturn=new CgReturn(null,vo.getDdcode(),nowtime,vo.getExplain(),null,null,0);
        cgReturn.setSupplier(vo.getSupplier());
        cgReturn.setCk(vo.getCk());
        cgReturn.setUser(vo.getUser());
        int i= mapper.addTh(cgReturn);
        cgReturn.setReId(cgReturn.getReId());
        GoodsArr[] tableData= vo.getTableData();
        if(i>0){
            for(int a=0;a<vo.getTableData().length;a++){
                //订单商品详情
                System.out.println("tableData[a].getGoId()="+tableData[a].getGoId());
                JcGoods goods=new JcGoods();
                goods.setGoId(tableData[a].getGoId());
                System.out.println("tableData[a].getGBian()="+tableData[a].getgBian());
                CgReturndetail cgReturndetail=new CgReturndetail(null,tableData[a].getgBian(),tableData[a].getgPrice());
                cgReturndetail.setGoods(goods);
                cgReturndetail.setCgReturn(cgReturn);
                i=cgReturndetailMapper.addDetail(cgReturndetail);
            }
        }
        return i;
    }



}
