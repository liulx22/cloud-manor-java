package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.OrderMapper;
import com.buba.cloud.cloudManor.pojo.OrderHistoricalVO;
import com.buba.cloud.cloudManor.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* User: 智慧
 * \* Date: 2020/8/14
 * \* Time: 17:53
 * \* 模块:订单
 * \
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    public OrderMapper orderMapper;
    @Override
    public List<OrderHistoricalVO> GETOrderHistoricalVO(int userId,String shijian,String leixing) {
        return orderMapper.GETOrderHistoricalVO(userId,shijian,leixing);
    }
}
