package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.IndexVO;
import com.buba.cloud.cloudManor.pojo.OrderAgricultureVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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
    /**
     * 获取首页视频地址和信息
     * @return
     */
    List<IndexVO> getIndex();
}
