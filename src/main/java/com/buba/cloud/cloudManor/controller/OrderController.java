package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.OrderHistoricalVO;
import com.buba.cloud.cloudManor.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* User: 智慧
 * \* Date: 2020/8/14
 * \* Time: 17:58
 * \* 模块:订单
 * \
 */
@RequestMapping("order")
@Controller
public class OrderController {
    @Resource
    private OrderService orderService;

    //历史订单
    @RequestMapping("GETOrderHistoricalVO")
    @ResponseBody
    public List<OrderHistoricalVO> GETOrderHistoricalVO(Integer userId,String leixing,String shijian){
        List<OrderHistoricalVO> list=orderService.GETOrderHistoricalVO(userId,shijian,leixing);
        return list;
    }


}
