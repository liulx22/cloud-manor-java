package com.buba.cloud.cloudManor.service.impl;



import com.buba.cloud.cloudManor.mapper.ResourceMapper;
import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.ResourceAnimalDetail;
import com.buba.cloud.cloudManor.pojo.ResourceGroundDetail;
import com.buba.cloud.cloudManor.pojo.ResourceTreeDetail;
import com.buba.cloud.cloudManor.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;


    @Override
    public Resource findLordzhuangresource() {
        return resourceMapper.selectLardResource();
    }

    @Override
    public Resource selectResourceType(Integer resourceId) {
        return resourceMapper.selectResourceType(resourceId) ;
    }

    @Override
    public ResourceTreeDetail resourceFruiterMessage(Integer resourceId) {
        return resourceMapper.resourceFruiterMessage(resourceId);
    }

    @Override
    public ResourceAnimalDetail resourceLivestockMessage(Integer resourceId) {
        return resourceMapper.resourceLivestockMessage(resourceId);
    }

    @Override
    public ResourceGroundDetail resourcePlotMessage(Integer resourceId) {
        return resourceMapper.resourcePlotMessage(resourceId);
    }
}
