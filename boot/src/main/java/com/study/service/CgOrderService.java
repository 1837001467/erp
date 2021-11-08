package com.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.entity.*;
import com.study.mapper.*;
import com.study.vo.AddOrder;
import com.study.vo.GoodsArr;
import com.study.vo.SearchOrderAndPage;
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
public class CgOrderService {
    @Autowired
    CgOrderMapper mapper;
    @Autowired
    JcSupplierMapper supplierMapper;
    @Autowired
    JcGoodsMapper goodsMapper;
    @Autowired
    QxDepartmentMapper departmentMapper;
    @Autowired
    QxUserMapper userMapper;
    @Autowired
    CgOrderdetailMapper orderdetailMapper;
    @Autowired
    CgPriceMapper priceMapper;
    @Autowired
    QxUserMapper qxUserMapper;

    public List<CgOrder> selectlist(){
        return mapper.list();
    }

    //审批
    public Integer examine(Integer orid,String spidea,String applystate){
        System.out.println("prid="+orid+"spidea="+spidea+"applystate="+applystate);
        Timestamp nowtime= new Timestamp(System.currentTimeMillis());
        CgOrder cgOrder=new CgOrder();
        cgOrder.setOrId(orid);
        cgOrder.setOrSptime(nowtime);
        cgOrder.setOrSpopinon(spidea);
        if(applystate.equals("1")){//同意
            cgOrder.setOrState(1);
        }else{//不同意
            cgOrder.setOrState(3);
        }
        //采购部门主管
        QxUser qxUser=qxUserMapper.selectCgZg();
        cgOrder.setSppeo(qxUser);
        System.out.println("哈哈哈哈哈哈哈哈哈哈"+cgOrder);
        int i=mapper.updateCgOrder(cgOrder);
        System.out.println("qqqqqq"+i);
        return i;
    }

    //分页条件查询
    public PageInfo<CgOrder> selectByPager(SearchOrderAndPage vo){
        System.out.println("service:"+vo);
        PageHelper.startPage(vo.getNo(),vo.getSize());/*开启分页模式*/
        List<CgOrder> list = mapper.searchByKeyword(vo);/*调用mapper的查询方法*/
        return new PageInfo(list);/*将查询结果封装到PageInfo对象中并返回*/
    }

    public Integer addorder(AddOrder vo){
        System.out.println("进入addorder"+vo);
        Timestamp nowtime= new Timestamp(System.currentTimeMillis());
        CgOrder cgOrder=new CgOrder(null,vo.getDdcode(),vo.getExplain(),nowtime,null,null,0);
        System.out.println("vo.getGys()="+vo.getGys());
        cgOrder.setJcSupplier(vo.getGys());
        cgOrder.setQxDepartment(vo.getBm());
        cgOrder.setQxUser(vo.getUser());
        mapper.addOrder(cgOrder);
        cgOrder.setOrId(cgOrder.getOrId());

        GoodsArr[] tableData= vo.getTableData();
        System.out.println("tableData="+tableData);

        int i=0;
        //根据id修改采购报价单状态
        if (vo.getState() == 0) {
           i=priceMapper.updateStateById(vo.getPrid());
        }
        for(int a=0;a<vo.getTableData().length;a++){
            //订单商品详情
            System.out.println("tableData[a].getGoId()="+tableData[a].getGoId());
            JcGoods goods=new JcGoods();
            goods.setGoId(tableData[a].getGoId());
            System.out.println("tableData[a].getGBian()="+tableData[a].getGBian());
            CgOrderdetail cgOrderdetail=new CgOrderdetail(null,tableData[a].getGBian(),tableData[a].getGPrice());
            cgOrderdetail.setOrder(cgOrder);
            cgOrderdetail.setGoods(goods);
            i=orderdetailMapper.addOrderDetail(cgOrderdetail);
        }
        return i;
    }

}
