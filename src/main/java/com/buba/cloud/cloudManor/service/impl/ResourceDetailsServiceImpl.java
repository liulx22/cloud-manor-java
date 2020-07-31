package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.ResourceDetailsMapper;
import com.buba.cloud.cloudManor.pojo.Agriculture;
import com.buba.cloud.cloudManor.pojo.AgricultureOperation;
import com.buba.cloud.cloudManor.service.ResourceDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* User: 智慧
 * \* Date: 2020/7/28
 * \* Time: 18:07
 * \* 模块:资源详情
 * \
 */
@Service
public class ResourceDetailsServiceImpl implements ResourceDetailsService {
    @Resource
    private ResourceDetailsMapper resourceDetailsMapper;


    @Override
    public Agriculture GETAgriculture(int rid,int mid) {
        return resourceDetailsMapper.GETAgriculture(rid,mid);
    }

    @Override
    public boolean INSAgriculture(Agriculture agriculture) {
        return resourceDetailsMapper.INSAgriculture(agriculture);
    }

    @Override
    public List<AgricultureOperation> GETAgricultureOperation(int rid,int mid) {
        return resourceDetailsMapper.GETAgricultureOperation(rid,mid);
    }
}
