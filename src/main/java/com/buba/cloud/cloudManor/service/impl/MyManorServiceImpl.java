package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.MyManorMapper;
import com.buba.cloud.cloudManor.pojo.IndexVO;
import com.buba.cloud.cloudManor.pojo.OrderAgricultureVO;
import com.buba.cloud.cloudManor.service.MyManorService;
import com.buba.cloud.cloudManor.utils.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName MyManorServiceImpl
 * @Description
 * @Created by Administrator on 2020/7/24 15:34
 * @Version 1.0
 **/
@Service
public class MyManorServiceImpl implements MyManorService {

    @Resource
    private MyManorMapper myManorMapper;
    @Resource
    private RedisUtils redisUtils;

    //获取我的关注数量
    @Override
    public int getAttentionNum(Integer userId) {
        return myManorMapper.getAttentionNum(userId);
    }

    //获取我的喜欢数量
    @Override
    public int getMyLikeNum(Integer userId) {
        return myManorMapper.getMyLikeNum(userId);
    }

    //获取我的评论数量
    @Override
    public int getMyCommentNum(Integer userId) {
        return myManorMapper.getMyCommentNum(userId);
    }

    //获取我的订单数量
    @Override
    public int getMyOrderNum(Integer userId) {
        return myManorMapper.getMyOrderNum(userId);
    }

    //获取我的庄园 当前农事和视频
    @Override
    public List<OrderAgricultureVO> getOrderAgriculture(Integer userId) {
        List<OrderAgricultureVO> list = myManorMapper.getOrderAgriculture(userId);
        for (OrderAgricultureVO orderAgricultureVO : list) {
            System.out.println(orderAgricultureVO);
        }
        return list;
    }

    /**
     * 获取首页视频地址和信息
     * @return
     */
    @Override
    public List<IndexVO> getIndex() {
        return myManorMapper.getIndex();
    }
}
