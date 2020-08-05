package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.UserAttentionVo;

import java.util.List;

public interface AttentionService {
    //查询关注人
    List<UserAttentionVo> SelAttrntion(Integer id);
    //关注
    int Attrntion(Integer userId,Integer userId2);
    //取消关注  userId2 被关注人id  userId 关注人id
    int CancelTheAttention(Integer userId,Integer userId2);
    //粉丝数量
    int SelectAttention(Integer userId2);
    //关注数量
    int SelectAttention_1(Integer userId);
}
