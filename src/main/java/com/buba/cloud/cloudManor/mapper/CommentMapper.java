package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    int addComment(@Param("userId") Integer userId, @Param("content") String content, @Param("resourceId") Integer resourceId, @Param("pid") Integer pid);

    List<Comment> huiXianComment(@Param("resourceId") Integer resourceId);

    List<Comment> getAllWo(int id);
    List<Comment> getAll(int id);
    int delete (int id);


}
