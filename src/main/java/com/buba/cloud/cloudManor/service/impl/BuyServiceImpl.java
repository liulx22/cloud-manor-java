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
    @Autowired
    private OrderMapper orderMapper;

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
     *
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
     *
     * @Param: [resourceId]
     * @Return: com.buba.cloud.cloudManor.pojo.ResourceTreeDetail
     * @Author: ggx
     * @Date: 2020/7/26 0026 15:05
     */
    @Override
    public ResourceTreeDetail resourceFruiterMessage(Integer resourceId) {
        return resourceTreeDetailMapper.resourceFruiterMessage(resourceId);
    }

    /**
     * 功能描述:通过资源id查询畜牧具体信息
     *
     * @Param: [resourceId]
     * @Return: com.buba.cloud.cloudManor.pojo.ResourceAnimalDetail
     * @Author: ggx
     * @Date: 2020/7/26 0026 15:05
     */
    @Override
    public ResourceAnimalDetail resourceLivestockMessage(Integer resourceId) {
        return resourceAnimalDetailMapper.resourceLivestockMessage(resourceId);

    }

    /**
     * 功能描述: 通过资源id查询地块具体信息
     *
     * @Param: [resourceId]
     * @Return: com.buba.cloud.cloudManor.pojo.ResourceGroundDetail
     * @Author: ggx
     * @Date: 2020/7/26 0026 15:05
     */
    @Override
    public ResourceGroundDetail resourcePlotMessage(Integer resourceId) {
        return resourceGroundDetailMapper.resourcePlotMessage(resourceId);
    }


    /**
     * 功能描述:查询今日订单数量
     *
     * @Param: []
     * @Return: java.lang.Integer
     * @Author: ggx
     * @Date: 2020/7/31 0031 16:23
     */
    @Override
    public Integer orderRunningNum() {
        return orderMapper.orderRunningNum();
    }

    /**
     * 功能描述:通过资源id查询该资源的价格
     *
     * @Param: [resourceId]
     * @Return: java.lang.Double
     * @Author: ggx
     * @Date: 2020/7/31 0031 18:03
     */
    @Override
    public Double moneySafety(Integer resourceId) {
        return resourceMapper.moneySafety(resourceId);
    }

    /**
     * 功能描述:录入订单信息
     *
     * @Param: [order]
     * @Return: java.lang.Boolean
     * @Author: ggx
     * @Date: 2020/7/31 0031 18:10
     */
    @Override
    public Boolean addOrder(Order order) {
        return buyMapper.addOrder(order);
    }
}
