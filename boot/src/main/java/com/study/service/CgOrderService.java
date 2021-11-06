package com.study.service;

import com.study.entity.CgOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.mapper.CgOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
public interface CgOrderService extends IService<CgOrder> {
    List<CgOrder> selectlist();

}
