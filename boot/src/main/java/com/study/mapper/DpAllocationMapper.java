package com.study.mapper;

import com.study.entity.DpAllocation;
import com.study.entity.JcGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author
 * @since 2021-11-06
 */
@Mapper
public interface DpAllocationMapper {
    //分页查询所有库存调拨记录
    List<DpAllocation> selectPager();
    //根据编号查询库存调拨记录
    DpAllocation  selectBydpBian(String dpBian);
    //根据编号查询修改库存调拨记录状态
    Integer  UpdateBydpBian(@Param("dpBian") String dpBian,@Param("dpState") Integer dpStste);
    //根据编号查询写入库存调拨记录状态的审批人
    void adopt(@Param("yhId")Integer yhId,@Param("time") Timestamp time,@Param("dpBian") String dpBian);
    //查询某个仓库里所有的商品
    List<JcGoods> selectByWhid(Integer out);
    //新增仓库调拨记录
    Integer add(@Param("outhouse")Integer outhouse,@Param("inhouse") Integer inhouse,@Param("num") Integer num,
             @Param("gid")Integer gid, @Param("yhid")Integer yhid, @Param("timestamp")Timestamp timestamp,
             @Param("dpstate")Integer dpstate, @Param("bian")String bian);
}
