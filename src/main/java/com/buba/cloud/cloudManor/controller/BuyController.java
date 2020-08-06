package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.Order;
import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.ResourceType;
import com.buba.cloud.cloudManor.pojo.User;
import com.buba.cloud.cloudManor.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
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
     *
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
            if (resource != null) {
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

    /**
     * 功能描述:录入订单信息
     *
     * @Param: [userId, resourceId, desc]
     * @Return: java.lang.Boolean
     * @Author: ggx
     * @Date: 2020/7/31 0031 18:58
     */
    @RequestMapping("addOrder")
    public Boolean addOrder(Integer userId, Integer resourceId, String desc) {
        if (userId != null && resourceId != null) {
            Integer orderRunningNum = null;
            Format threeNum = new DecimalFormat("000");
            Order order = new Order();
            //获取当前时间的yyyyMMdd形式 用于生成订单编号
            SimpleDateFormat sim = new SimpleDateFormat("yyyyMMdd");
            Integer datenum = Integer.parseInt(sim.format(new Date()));
            //去数据库查询该订单为今日的第几份订单 用于生成订单编号
            orderRunningNum = buyService.orderRunningNum();
            if (orderRunningNum != null) {
                //使用时间和流水号进行拼接 并且转换类型
                Long s = Long.parseLong(datenum + threeNum.format(orderRunningNum + 1));
                order.setOrderNo(s);
            } else {
                //使用时间和流水号进行拼接 并且转换类型
                Long format = Long.parseLong(threeNum.format(1));
                order.setOrderNo(datenum + format);
            }
            //通过资源id去查询该商品的金额，为了确保前端篡改金额
            Double money = buyService.moneySafety(resourceId);
            order.setMoney(money);
            order.setResourceId(resourceId);
            order.setUserId(userId);
            order.setDesc(desc);
            order.setDigitalCode("待支付");
            //进行订单录入
            return buyService.addOrder(order);
        }
        return false;
    }
}