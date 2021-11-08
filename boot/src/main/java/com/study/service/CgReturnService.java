package com.study.service;

import com.study.entity.*;
import com.study.mapper.CgReturnMapper;
import com.study.mapper.CgStorageMapper;
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

    public List<CgReturn> all(){
        return mapper.all();
    }

    //退货(入库不通过，进入退货)//新增
    public Integer tuihuo(String rkcode){
        Timestamp nowtime= new Timestamp(System.currentTimeMillis());
        //入库单
        CgStorage rk=storageMapper.selectByCode(rkcode);
        JcSupplier supplier=rk.getJcSupplier();//供应商
        QxUser user=rk.getQxUser();//采购员
        JcWhinformation ck=rk.getCk();//仓库
        //生成退货编码
        Calendar now = Calendar.getInstance();
        String year = String.valueOf(now.get(Calendar.YEAR));
        String month = String.valueOf(now.get(Calendar.MONTH)+1);
        String day = String.valueOf(now.get(Calendar.DAY_OF_MONTH));
        String num = String.valueOf((int)((Math.random()*9+1)*1000));
        String proceedsYard = "THD"+year+month+day+num;

        CgReturn cgReturn=new CgReturn(null,proceedsYard,nowtime,"入库失败，商品有质量问题",null,null,2);
        return mapper.addTh(cgReturn);
    }



}
