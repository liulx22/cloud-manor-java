package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.IndexVO;
import com.buba.cloud.cloudManor.pojo.OrderAgricultureVO;
import com.buba.cloud.cloudManor.service.MyManorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName MyManorController
 * @Description
 * @Created by Administrator on 2020/7/24 15:30
 * @Version 1.0
 **/
@RestController
@RequestMapping("/myManor")
public class MyManorController {

    @Autowired
    private MyManorService myManorService;


    //获取我的关注数量
    @RequestMapping("getAttentionNum")
    public int getAttentionNum(Integer userId){
        return myManorService.getAttentionNum(userId);
    }
    //获取我的喜欢数量
    @RequestMapping("getMyLikeNum")
    public int getMyLikeNum(Integer userId){
        return myManorService.getMyLikeNum(userId);
    }
    //获取我的评论数量
    @RequestMapping("getMyCommentNum")
    public int getMyCommentNum(Integer userId){
        return myManorService.getMyCommentNum(userId);
    }
    //获取我的订单数量
    @RequestMapping("getMyOrderNum")
    public int getMyOrderNum(Integer userId){
        return myManorService.getMyOrderNum(userId);
    }

    //获取我的庄园 当前农事和视频
    @RequestMapping("getOrderAgriculture")
    public List<OrderAgricultureVO> getOrderAgriculture(Integer userId){
        return myManorService.getOrderAgriculture(userId);
    }

    /**
     * 获取首页视频地址和信息
     * @return
     */
    @RequestMapping("getIndex")
    public List<IndexVO> getIndex(){

        return myManorService.getIndex();
    }
}
