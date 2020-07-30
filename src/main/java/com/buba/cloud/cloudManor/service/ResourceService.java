package com.buba.cloud.cloudManor.service;


import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.ResourceAnimalDetail;
import com.buba.cloud.cloudManor.pojo.ResourceGroundDetail;
import com.buba.cloud.cloudManor.pojo.ResourceTreeDetail;

public interface ResourceService {
    Resource findLordzhuangresource();

    Resource selectResourceType(Integer resourceId);

    ResourceTreeDetail resourceFruiterMessage(Integer resourceId);

    ResourceAnimalDetail resourceLivestockMessage(Integer resourceId);

    ResourceGroundDetail resourcePlotMessage(Integer resourceId);
}
