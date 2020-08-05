package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.UserAttentionVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
public interface AttentionMapper {
    //查询关注人
    List<UserAttentionVo> SelAttrntion(Integer id);
    //关注
    int Attrntion(@Param("userId") Integer userId, @Param("userId2")Integer userId2);
    //取消关注
    int CancelTheAttention(@Param("userId")Integer userId,@Param("userId2")Integer userId2);
}
