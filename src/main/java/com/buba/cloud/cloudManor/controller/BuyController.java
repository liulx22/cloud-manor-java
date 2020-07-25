package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.User;
import com.buba.cloud.cloudManor.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @Param: [resourceId]
     * @Return: com.buba.cloud.cloudManor.pojo.User
     * @Author: ggx
     * @Date: 2020/7/24 0024 16:20
     */
     @RequestMapping("obtainMaintenancePeopleMessage")
     public User obtainMaintenancePeopleMessage(Integer resourceId){
          //判断用户id是否为空
          if(resourceId!=null){
          //通过资源id去获取养护人信息
           return buyService.obtainMaintenancePeopleMessage(resourceId);
          }
          //如果为空 返回null
          return null;
     }
     //public





}
