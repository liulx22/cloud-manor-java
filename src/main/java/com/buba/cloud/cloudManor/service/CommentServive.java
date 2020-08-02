package com.buba.cloud.cloudManor.service;



import com.buba.cloud.cloudManor.pojo.Comment;

import java.util.List;

public interface CommentServive {
    int addComment(Integer userId, String content, Integer resourceId, Integer pid);

    List<Comment> huiXianComment(Integer userid);
    List<Comment> getAllWo(int id);
    List<Comment> getAll(int id);
    int delete (int id);
}
