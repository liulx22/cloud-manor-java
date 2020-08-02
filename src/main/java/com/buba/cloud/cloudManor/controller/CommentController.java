package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.Comment;
import com.buba.cloud.cloudManor.service.CommentServive;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
@Controller
@RequestMapping("CommentController")
public class CommentController {
    @Resource
    private CommentServive commentService;
    @ResponseBody
    @RequestMapping("getAllWo")
    public List<Comment> getAllWo(int id){
        System.out.println(id+"4444444444444444444444444444444444");
        List<Comment> list = commentService.getAllWo(id);
        System.out.println(list);
        return list;
    }
    @ResponseBody
    @RequestMapping("getAll")
    public List<Comment> getAll(int id){
        System.out.println(id+"888888888888888888888888");
        List<Comment> list = commentService.getAll(id);
        System.out.println(list);
        return list;
    }

    @ResponseBody
    @RequestMapping("delete")
    public int delete(int id){
        System.out.println(id+"deletedeletedeletedeletedeletedeletedeletedeletedeletedeletedeletedelete");
        int delete = commentService.delete(id);

        return delete;
    }
}
