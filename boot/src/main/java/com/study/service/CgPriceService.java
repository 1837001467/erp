package com.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.entity.*;
import com.study.mapper.CgPriceMapper;
import com.study.mapper.CgPricedetailMapper;
import com.study.mapper.QxUserMapper;
import com.study.vo.AddOrder;
import com.study.vo.GoodsArr;
import com.study.vo.SearchOrderAndPage;
import com.study.vo.SearchPriceByPager;
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
public class CgPriceService{
    @Autowired
    CgPriceMapper mapper;
    @Autowired
    QxUserMapper qxUserMapper;
    @Autowired
    CgPricedetailMapper cgPricedetailMapper;

    //分页条件查询
    public PageInfo<CgPrice> SearchPriceByPager(SearchPriceByPager vo){
        PageHelper.startPage(vo.getNo(),vo.getSize());/*开启分页模式*/
        List<CgPrice> list = mapper.selectByKeyword(vo);/*调用mapper的查询方法*/
        return new PageInfo(list);/*将查询结果封装到PageInfo对象中并返回*/
    }

    //审批
    public Integer examine(Integer prid,String spidea,String applystate){
        System.out.println("prid="+prid+"spidea="+spidea+"applystate="+applystate);
        Timestamp nowtime= new Timestamp(System.currentTimeMillis());
        CgPrice cgPrice= mapper.selectByPrid(prid);
        cgPrice.setPrSptime(nowtime);
        cgPrice.setPrSpopinon(spidea);
        if(applystate.equals("1")){//同意
            cgPrice.setPrState(1);
        }else{//不同意
            cgPrice.setPrState(3);
        }
        //采购部门主管
        QxUser qxUser=qxUserMapper.selectCgZg();
        cgPrice.setSppeo(qxUser);
        return mapper.updateCgPrice(cgPrice);
    }

    //新增采购报价单
    public Integer add(AddOrder vo){
        System.out.println("进入add"+vo);
        Timestamp nowtime= new Timestamp(System.currentTimeMillis());
        CgPrice cgPrice=new CgPrice(null,vo.getDdcode(),vo.getPrname(),vo.getXqtime(),vo.getTotalmoney(),vo.getExplain(),nowtime,null,null,0);
        cgPrice.setJcSupplier(vo.getGys());
        cgPrice.setQxDepartment(vo.getBm());
        cgPrice.setQxUser(vo.getUser());
        int i= mapper.addCgprice(cgPrice);
        cgPrice.setPrId(cgPrice.getPrId());
        GoodsArr[] tableData= vo.getTableData();
        if(i>0){
            for(int a=0;a<vo.getTableData().length;a++){
                //订单商品详情
                System.out.println("tableData[a].getGoId()="+tableData[a].getGoId());
                JcGoods goods=new JcGoods();
                goods.setGoId(tableData[a].getGoId());
                System.out.println("tableData[a].getGBian()="+tableData[a].getgBian());
                CgPricedetail cgPricedetail=new CgPricedetail(null,tableData[a].getgBian(),tableData[a].getgPrice());
                cgPricedetail.setGoods(goods);
                cgPricedetail.setCgPrice(cgPrice);
                i=cgPricedetailMapper.addDetail(cgPricedetail);
            }
        }
        return i;
    }

}
