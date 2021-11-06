package com.study.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 职位权限中间表格 服务类
 * </p>
 *
 * @author zzl
 * @since 2021-11-06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class QxMiddlePostService{

}
