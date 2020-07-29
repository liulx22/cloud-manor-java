package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.OrderAgricultureVO;

import java.util.List;

public interface MyManorMapper {
   //获取我的关注数量
    int getAttentionNum(Integer userId);
    //获取我的喜欢数量
    int getMyLikeNum(Integer userId);
    //获取我的评论数量
    int getMyCommentNum(Integer userId);
    //获取我的订单数量
    int getMyOrderNum(Integer userId);
    //获取我的庄园 当前农事和视频
    List<OrderAgricultureVO> getOrderAgriculture(Integer userId);
}
