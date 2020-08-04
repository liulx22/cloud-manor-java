package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.CommentMapper;
import com.buba.cloud.cloudManor.pojo.Comment;
import com.buba.cloud.cloudManor.service.CommentServive;
import com.buba.cloud.cloudManor.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;

@Service
public class CommentServiveImpl implements CommentServive {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private RedisUtils redisUtils;

    //用户有多少评论数readis(UserID)
    @Override
    public int readisUser(Integer userId) {
        String a=userId.toString();//用户的readis+1
        Integer addcomment = (Integer) redisUtils.hget(a, "commentnum" + a);//获取用户redis的这个值：0
        if(addcomment==null){
            addcomment=0;
        }
        redisUtils.hset(a,"commentnum"+a,addcomment+1);//让redis的值增加： 1
        int  addcomment2 = (int)redisUtils.hget(a, "commentnum" + a);//获取添加后的值: 1
        System.out.println("该用户下拥有"+addcomment2+"条评论");
        return  addcomment2;
    }

    //readis作品评论数
    @Override
    public int readisResource(Integer resourceId) {
        String b=resourceId.toString();//用户的readis+1
        Integer addcomment = (Integer) redisUtils.hget(b, "commentnum" + b);//获取用户redis的这个值：0
        if(addcomment==null){
            addcomment=0;
        }
        redisUtils.hset(b,"commentnum"+b,addcomment+1);//让redis的值增加： 1
        int  addcomment0 = (int)redisUtils.hget(b, "commentnum" + b);//获取添加后的值: 1
        System.out.println("该作品下拥有"+addcomment0+"条评论");
        return  addcomment0;
    }


    //添加评论
    @Override
    public int addComment(Integer userId, String content, Integer resourceId, Integer pid) {
        int i = commentMapper.addComment(userId, content, resourceId, pid);
        if(i!=0){
            readisUser(userId);//调用添加radis里user评论数
            readisResource(resourceId);//调用添加radis里作品评论数
        }
        return i;

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
    public int delete(int id,Integer userId) {

        String a=userId.toString();//用户的readis+1
        Integer addcomment = (Integer) redisUtils.hget(a, "commentnum" + a);//获取用户redis的这个值：0
        if(addcomment==null){
            addcomment=0;
        }
        redisUtils.hset(a,"commentnum"+a,addcomment-1);//让redis的值增加： 1
        int  addcomment2 = (int)redisUtils.hget(a, "commentnum" + a);//获取添加后的值: 1
        System.out.println("该用户下还剩"+addcomment2+"条评论");
        return  addcomment2;


    }
}
