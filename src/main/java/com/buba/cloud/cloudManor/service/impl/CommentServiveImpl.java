package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.CommentMapper;
import com.buba.cloud.cloudManor.pojo.Comment;
import com.buba.cloud.cloudManor.service.CommentServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiveImpl implements CommentServive {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public int addComment(Integer userId, String content, Integer resourceId, Integer pid) {
        return commentMapper.addComment( userId,content,resourceId,pid);
    }

    @Override
    public List<Comment> huiXianComment(Integer userid) {
        return commentMapper.huiXianComment( userid);
    }

    @Override
    public List<Comment> getAllWo(int id) {
        List<Comment> list = commentMapper.getAllWo(id);
        return list;
    }

    @Override
    public List<Comment> getAll(int id) {
        List<Comment> list = commentMapper.getAll(id);
        return list;
    }



    @Override
    public int delete(int id) {
        return commentMapper.delete(id);
    }
}
