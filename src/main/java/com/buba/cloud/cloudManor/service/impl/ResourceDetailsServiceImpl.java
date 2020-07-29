package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.ResourceDetailsMapper;
import com.buba.cloud.cloudManor.pojo.Agriculture;
import com.buba.cloud.cloudManor.pojo.AgricultureOperation;
import com.buba.cloud.cloudManor.service.ResourceDetailsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* User: 智慧
 * \* Date: 2020/7/28
 * \* Time: 18:07
 * \* 模块:资源详情
 * \
 */
public class ResourceDetailsServiceImpl implements ResourceDetailsService {
    @Resource
    private ResourceDetailsMapper resourceDetailsMapper;


    @Override
    public Agriculture GETAgriculture(int id) {
        return resourceDetailsMapper.GETAgriculture(id);
    }

    @Override
    public List<AgricultureOperation> GETAgricultureOperation(int id) {

        return resourceDetailsMapper.GETAgricultureOperation(id);
    }
}
