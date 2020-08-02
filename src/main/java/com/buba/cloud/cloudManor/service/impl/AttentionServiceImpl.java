package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.AttentionMapper;
import com.buba.cloud.cloudManor.pojo.UserAttentionVo;
import com.buba.cloud.cloudManor.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttentionServiceImpl implements AttentionService {
    @Autowired
    private AttentionMapper attentionMapper;

    @Override
    public List<UserAttentionVo> SelAttrntion(Integer id) {
        return attentionMapper.SelAttrntion(id);
    }

    @Override
    public boolean Attrntion(Integer userId,Integer userId2) {
        return attentionMapper.Attrntion(userId,userId2);
    }

    @Override
    public boolean CancelTheAttention(Integer id,Integer userId2) {
        return attentionMapper.CancelTheAttention(id,userId2);
    }
}
