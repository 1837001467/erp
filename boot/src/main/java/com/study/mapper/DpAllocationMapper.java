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
    List<DpAllocation> selectPager();

    DpAllocation  selectBydpBian(String dpBian);

    Integer  UpdateBydpBian(@Param("dpBian") String dpBian,@Param("dpState") Integer dpStste);

    void adopt(@Param("yhId")Integer yhId,@Param("time") Timestamp time,@Param("dpBian") String dpBian);

    List<JcGoods> selectByWhid(Integer out);

    Integer add(@Param("outhouse")Integer outhouse,@Param("inhouse") Integer inhouse,@Param("num") Integer num,
             @Param("gid")Integer gid, @Param("yhid")Integer yhid, @Param("timestamp")Timestamp timestamp,
             @Param("dpstate")Integer dpstate, @Param("bian")String bian);
}
