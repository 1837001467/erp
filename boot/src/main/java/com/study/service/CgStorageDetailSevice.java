package com.study.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 邱艳丽
 * @date 2021-11-07
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CgStorageDetailSevice {

}
