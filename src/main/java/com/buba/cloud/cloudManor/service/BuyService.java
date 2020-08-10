package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.*;

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
public interface BuyService {
    //通过资源id获取养护人信息
    User obtainMaintenancePeopleMessage(Integer resourceId);

    //通过资源id查询资源信息
    Resource resourceMessage(Integer resourceId);

    //通过资源id查询树木具体信息
    ResourceTreeDetail resourceFruiterMessage(Integer resourceId);

    //通过资源id查询畜牧具体信息
    ResourceAnimalDetail resourceLivestockMessage(Integer resourceId);

    //通过资源id查询地块具体信息
    ResourceGroundDetail resourcePlotMessage(Integer resourceId);

    //查询今日订单数量
    Integer orderRunningNum();

    //通过资源id查询该资源的价格
    Double moneySafety(Integer resourceId);

    //录入订单信息
    Boolean addOrder(Order order);

    List<Order> findBuyCount();
}
