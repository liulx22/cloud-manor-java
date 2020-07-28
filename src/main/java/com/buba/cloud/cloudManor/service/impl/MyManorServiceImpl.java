package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.MyManorMapper;
import com.buba.cloud.cloudManor.service.MyManorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName MyManorServiceImpl
 * @Description
 * @Created by Administrator on 2020/7/24 15:34
 * @Version 1.0
 **/
@Service
public class MyManorServiceImpl implements MyManorService {

    @Resource
    private MyManorMapper myManorMapper;
}
