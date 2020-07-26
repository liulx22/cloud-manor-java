package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.ResourceType;
import com.buba.cloud.cloudManor.pojo.User;
import com.buba.cloud.cloudManor.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: cloud-manor-java
 * @Package: com.buba.cloud.cloudManor.GgxPlaceOrder
 * @ClassName: BuyController
 * @Author: ggx
 * @Description: 下订单页面 接口
 * @Date: 2020/7/24 0024 14:58
 * @Version: 1.0
 */
@RestController
public class BuyController {
    @Autowired
    private BuyService buyService;

    /**
     * 功能描述:通过资源id获取养护人信息
     *
     * @Param: [resourceId]
     * @Return: com.buba.cloud.cloudManor.pojo.User
     * @Author: ggx
     * @Date: 2020/7/24 0024 16:20
     */
    @RequestMapping("obtainMaintenancePeopleMessage")
    public User obtainMaintenancePeopleMessage(Integer resourceId) {
        //判断资源id是否为空
        if (resourceId != null) {
            //通过资源id去获取养护人信息
            return buyService.obtainMaintenancePeopleMessage(resourceId);
        }
        //如果为空 返回null
        return null;
    }
    /**
     * 功能描述:通过资源id查询资源信息，以及该资源的具体信息
     * @Param: [resourceId]
     * @Return: com.buba.cloud.cloudManor.pojo.Resource
     * @Author: ggx
     * @Date: 2020/7/26 0026 15:04
     */
    @RequestMapping("resourceMessage")
    public Resource resourceMessage(Integer resourceId) {
        //判断资源id是否为空
        if (resourceId != null) {
            //获取资源信息
            Resource resource = buyService.resourceMessage(resourceId);
            //如果资源信息不为null
            if(resource!=null){
                //获取资源类型
                String resourceType = resource.getReTypeCode();
                //如果资源类型不为null
                if (resourceType != null && !resourceType.equals("")) {
                    switch (resourceType) {
                        //如果类型为果树
                        case "fruiter":
                            resource.setResourceTreeDetail(buyService.resourceFruiterMessage(resourceId));
                            return resource;
                        //如果类型为畜牧
                        case "livestock":
                            resource.setResourceAnimalDetail(buyService.resourceLivestockMessage(resourceId));
                            return resource;
                        //如果类型为地块
                        case "plot":
                            resource.setResourceGroundDetail(buyService.resourcePlotMessage(resourceId));
                            return resource;
                    }
                }
                return null;
            }

        }
        //如果为空 返回null
        return null;
    }

}