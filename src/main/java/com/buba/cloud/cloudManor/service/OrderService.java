package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.OrderHistoricalVO;

import java.util.List;

public interface OrderService {
    //孙智慧 历史订单
    List<OrderHistoricalVO> GETOrderHistoricalVO(int userId,String shijian,String leixing);
}
