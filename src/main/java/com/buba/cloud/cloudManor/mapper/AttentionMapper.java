package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.UserAttentionVo;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
public interface AttentionMapper {
    //查询关注人
    List<UserAttentionVo> SelAttrntion();
    //关注
    boolean Attrntion(Integer userId);
    //取消关注
    boolean CancelTheAttention(Integer userId);
}
