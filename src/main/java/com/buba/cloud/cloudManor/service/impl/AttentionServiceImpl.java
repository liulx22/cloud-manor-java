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
        int b=  attentionMapper.Attrntion(userId,userId2);
      if (b!=0){
          boolean b1 = redisUtils.hHasKey("manor_attention_num", "manor_attention"+userId2 );
          if (b1==false){
             //设置初始值并为1
              redisUtils.hset("manor_attention_num", "manor_attention" + userId2, 1);
          }else {
              //如果该key与itm存在
              //获取redis中的关注量
              Integer manor_attention_num1 = (Integer) redisUtils.hget("manor_attention_num", "manor_attention" + userId2);
              //让redis中的关注人量+1
              redisUtils.hset("manor_attention_num", "manor_attention" + userId2, manor_attention_num1+1);
          }
          //判断该key与item是否存在
          boolean manor_attention_num = redisUtils.hHasKey("manor_attention_num_1", "manor_id" + userId);
          if (manor_attention_num == false) {
              //设置初始值并为1
              redisUtils.hset("manor_attention_num_1", "manor_id" + userId, 1);
              //如果该key与itm存在
          } else {
              //获取redis中的关注人
              Integer userId_1 = (Integer) redisUtils.hget("manor_attention_num_1", "manor_id" + userId);
              //让redis中的+1
              redisUtils.hset("manor_attention_num_1", "manor_id" + userId, userId_1 + 1);
          }

      }
      //返回关注量
        Integer manor_attention_num10 = (Integer) redisUtils.hget("manor_attention_num", "manor_id" + userId2);
        return manor_attention_num10;
    }

    @Override
    public int CancelTheAttention(Integer userId,Integer userId2) {
        int i = attentionMapper.CancelTheAttention(userId, userId2);
        if (i!=0){
            //判断该key与item是否存在
            boolean manor_attention_num_2 = redisUtils.hHasKey("manor_attention_num", "manor_attention" + userId);
            if (manor_attention_num_2 ==false) {
                //设置初始值并为1
                redisUtils.hset("manor_attention_num", "manor_attention" + userId, 1);
            } else {
                //如果该key与item存在
                //获取redis中的关注
                Integer manor_attention_num_1 = (Integer) redisUtils.hget("manor_attention_num", "manor_attention" + userId);
                //让redis中的关注量-1
                redisUtils.hset("manor_attention_num", "manor_attention" + userId, manor_attention_num_1 - 1);
            }
            //判断该key与item是否存在
            boolean manor_attention_num_3 = redisUtils.hHasKey("manor_attention_num_1", "manor_id" + userId2);
            if (manor_attention_num_3 ==false) {
                //设置初始值并为1
                redisUtils.hset("manor_attention_num_1", "manor_id" + userId2, 1);
            } else {
                //获取redis中的关注量
                Integer resource_like_number1 = (Integer) redisUtils.hget("manor_attention_num_1", "manor_id" + userId2);
                //让redis中的关注量-1
                redisUtils.hset("manor_attention_num_1", "manor_id" + userId2, resource_like_number1 - 1);
            }
        }
        //返回关注数量
        Integer manor_attention_num_4 = (Integer) redisUtils.hget("manor_attention_num", "manor_id" + userId2);
        return manor_attention_num_4;
    }

    @Override
    public int SelectAttention(Integer userId2) {
        //判断id是否存在
        boolean b1 = redisUtils.hHasKey("manor_attention_num", "manor_attention"+userId2 );
        if(b1==false){
            //设置初始0
            redisUtils.hset("manor_attention_num", "manor_attention" + userId2, 0);
            return 0;
        }
        //获取关注数量
        Integer manor_attention_num =(Integer) redisUtils.hget("manor_attention_num", "manor_attention" + userId2);
        return manor_attention_num;
    }

    @Override
    public int SelectAttention_1(Integer userId) {
        boolean manor_attention_num_2 = redisUtils.hHasKey("manor_attention_num", "manor_attention" + userId);
        if (manor_attention_num_2==false){
            //设置初始值并为1
            redisUtils.hset("manor_attention_num", "manor_attention" + userId, 0);
            return  0;
        }
        Integer userId_1 = (Integer) redisUtils.hget("manor_attention_num_1", "manor_id" + userId);
        return userId_1;
    }
}
