package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.UserAttentionVo;

import java.util.List;

public interface AttentionService {
    //查询关注人
    List<UserAttentionVo> SelAttrntion(Integer id);
    //关注
    boolean Attrntion(Integer userId,Integer userId2);
    //取消关注
    boolean CancelTheAttention(Integer userId,Integer userId2);
}
