package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.*;
import com.buba.cloud.cloudManor.pojo.*;
import com.buba.cloud.cloudManor.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @ProjectName: cloud-manor-java
 * @Package: com.buba.cloud.cloudManor.service
 * @ClassName: BuyService
 * @Author: ggx
 * @Description:
 * @Date: 2020/7/24 0024 16:09
 * @Version: 1.0
 */
@Service
public class BuyServiceImpl implements BuyService {

    @Autowired
    private BuyMapper buyMapper;

    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourceAnimalDetailMapper resourceAnimalDetailMapper;
    @Autowired
    private ResourceGroundDetailMapper resourceGroundDetailMapper;
    @Autowired
    private ResourceTreeDetailMapper resourceTreeDetailMapper;
    @Autowired
    private ResourceTypeMapper resourceTypeMapper;


    /**
     * 功能描述:通过资源id获取养护人信息
     *
     * @Param: [resourceId]
     * @Return: com.buba.cloud.cloudManor.pojo.User
     * @Author: ggx
     * @Date: 2020/7/24 0024 16:13
     */
    @Override
    public User obtainMaintenancePeopleMessage(Integer resourceId) {
        return buyMapper.obtainMaintenancePeopleMessage(resourceId);
    }
    /**
     * 功能描述: //通过资源id查询资源信息
     * @Param: [resourceId]
     * @Return: com.buba.cloud.cloudManor.pojo.Resource
     * @Author: ggx
     * @Date: 2020/7/26 0026 15:06
     */
    @Override
    public Resource resourceMessage(Integer resourceId) {
        return buyMapper.resourceMessage(resourceId);
    }

    /**
     * 功能描述:通过资源id查询树木具体信息
     * @Param: [resourceId]
     * @Return: com.buba.cloud.cloudManor.pojo.ResourceTreeDetail
     * @Author: ggx
     * @Date: 2020/7/26 0026 15:05
     */
    @Override
    public ResourceTreeDetail resourceFruiterMessage(Integer resourceId) {
        ResourceTreeDetail resourceTreeDetail = resourceTreeDetailMapper.selectOne(new ResourceTreeDetail().setResourceId(resourceId));
        return resourceTreeDetail;
    }
    /**
     * 功能描述:通过资源id查询畜牧具体信息
     * @Param: [resourceId]
     * @Return: com.buba.cloud.cloudManor.pojo.ResourceAnimalDetail
     * @Author: ggx
     * @Date: 2020/7/26 0026 15:05
     */
    @Override
    public ResourceAnimalDetail resourceLivestockMessage(Integer resourceId) {
        return resourceAnimalDetailMapper.selectOne(new ResourceAnimalDetail().setResourceId(resourceId));

    }
    /**
     * 功能描述: 通过资源id查询地块具体信息
     * @Param: [resourceId]
     * @Return: com.buba.cloud.cloudManor.pojo.ResourceGroundDetail
     * @Author: ggx
     * @Date: 2020/7/26 0026 15:05
     */
    @Override
    public ResourceGroundDetail resourcePlotMessage(Integer resourceId) {
        return resourceGroundDetailMapper.selectOne(new ResourceGroundDetail().setResourceId(resourceId));
    }
}
