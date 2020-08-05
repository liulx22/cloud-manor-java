package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.AttentionMapper;
import com.buba.cloud.cloudManor.pojo.UserAttentionVo;
import com.buba.cloud.cloudManor.service.AttentionService;
import com.buba.cloud.cloudManor.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttentionServiceImpl implements AttentionService {
    @Autowired
    private AttentionMapper attentionMapper;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public List<UserAttentionVo> SelAttrntion(Integer id) {
        return attentionMapper.SelAttrntion(id);
    }

    @Override
    public int Attrntion(Integer userId,Integer userId2) {
        String s = userId2.toString();
        //设置初始值
        redisUtils.hset("manor_attention_num", "manor_id" + s, 0);
        int b=  attentionMapper.Attrntion(userId,userId2);
      if (b!=0){
          // 获取redis中的关注
          Integer manor_attention_num =(Integer) redisUtils.hget("manor_attention_num", "manor_id" + s);
          //添加数据库成功 让Redis+1
          redisUtils.hset("manor_attention_num","manor_id"+s,manor_attention_num+1);
      }
        //添加成功返回关注数量
        Integer manor_attention_num = (Integer) redisUtils.hget("manor_attention_num", "manor_id" + s);
        return manor_attention_num;
    }

    @Override
    public int CancelTheAttention(Integer userId,Integer userId2) {
        String s = userId2.toString();
        int i = attentionMapper.CancelTheAttention(userId, userId2);
        if (i!=0){
            // 获取redis中的关注量
            Integer manor_attention_num =(Integer) redisUtils.hget("maitain_attention_num:", "maintain_id" + s);
            //数据库删除成功
            redisUtils.hset("maitain_attention_num:","maintain_id"+s,manor_attention_num-1);
        }
        Integer hget = (Integer) redisUtils.hget("maitain_attention_num:", "maintain_id" + s);
        return hget;
    }
}
