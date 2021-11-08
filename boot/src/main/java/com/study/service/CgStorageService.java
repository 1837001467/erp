package com.study.service;

import com.study.entity.*;
import com.study.mapper.*;
import com.study.vo.AddStorage;
import com.study.vo.GoodsArr;
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
public class CgStorageService{
    @Autowired
    CgStorageMapper mapper;
    @Autowired
    CgOrderMapper orderMapper;
    @Autowired
    CgStorageDetailMapper detailMapper;
    @Autowired
    CgYinpayMapper yinpayMapper;
    @Autowired
    QxUserMapper qxUserMapper;
    @Autowired
    RkApplyService rkApplyService;

    public List<CgStorage> all(){
        return mapper.all();
    }

    //新增采购入库单
    public Integer addstorage(AddStorage vo){
        System.out.println("进入addorder"+vo);
        Timestamp nowtime= new Timestamp(System.currentTimeMillis());
        CgStorage cgStorage=new CgStorage(null,vo.getDdcode(),vo.getExplain(),vo.getZh(),nowtime,null,null,0,vo.getTotalmoney());
        System.out.println("vo.getGys()="+vo.getGys());
        cgStorage.setJcSupplier(vo.getGys());
        cgStorage.setQxUser(vo.getUser());
        cgStorage.setCk(vo.getCk());
        mapper.addstorage(cgStorage);
        //入库申请
        rkApplyService.cgAdd(vo.getDdcode());

        cgStorage.setStId(cgStorage.getStId());

        GoodsArr[] tableData= vo.getTableData();
        System.out.println("tableData="+tableData);

        int i=0;
        //根据id修改采购报价单状态
        System.out.println("vo.getState+"+vo.getState());
        if(vo.getState()!=null){
            i=orderMapper.updataCgStateById(vo.getOrid());
        }

        for(int a=0;a<vo.getTableData().length;a++){
            //订单商品详情
            System.out.println("tableData[a].getGoId()="+tableData[a].getGoId());
            JcGoods goods=new JcGoods();
            goods.setGoId(tableData[a].getGoId());
            System.out.println("tableData[a].getGBian()="+tableData[a].getgBian());
            CgStorageDetail cgStorageDetail=new CgStorageDetail(null,tableData[a].getgBian(),tableData[a].getgPrice());
            cgStorageDetail.setGoods(goods);
            cgStorageDetail.setCgStorage(cgStorage);
            i=detailMapper.addSdDetail(cgStorageDetail);
        }

        //生成应付记账记录
        CgYinpay cgYinpay=new CgYinpay(null,vo.getZh(),null,null,vo.getTotalmoney(),nowtime,0);
        yinpayMapper.addYinPay(cgYinpay);

        return i;
    }

    //审批
    public Integer examine(Integer stid,String spidea,String applystate){
        System.out.println("prid="+stid+"spidea="+spidea+"applystate="+applystate);
        Timestamp nowtime= new Timestamp(System.currentTimeMillis());
        CgStorage cgStorage=new CgStorage();
        cgStorage.setStId(stid);
        cgStorage.setStSptime(nowtime);
        cgStorage.setStSpopinon(spidea);
        if(applystate.equals("1")){//同意
            cgStorage.setStState(1);
        }else{//不同意
            cgStorage.setStState(3);
        }
        //采购部门主管
        QxUser qxUser=qxUserMapper.selectCgZg();
        cgStorage.setSppeo(qxUser);
        System.out.println("哈哈哈哈哈哈哈哈哈哈"+cgStorage);
        int i=mapper.updateCgStorage(cgStorage);
        System.out.println("qqqqqq"+i);
        return i;
    }

}
