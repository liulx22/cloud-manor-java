package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.ResourceVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Iterator;

/**
 * @author Administrator
 * @create 2020-07-28 16:26
 * @desc 发布资源
 **/
@Controller
@RequestMapping("/web")
public class ReleaseResourceController {
    /*
     * @author fgh
     * @description 发布资源
     * @date 2020/7/28 16:28
     * @param @RequestParam("imageFile")MultipartFile[] imageFile
     * @return
     */
    @RequestMapping("/ceshi")
    @ResponseBody
    public boolean ceshi(HttpServletRequest request) {
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            Date now = new Date();
            while (iter.hasNext()) {
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    System.out.println(myFileName);
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                   /* if (myFileName.trim() != "") {
                        String type = myFileName.substring(0, myFileName.indexOf("-"));
                        System.out.println(type);
                    }*/
                }
            }
        }
        return true;
    }

    @RequestMapping("/ceshi1")
    @ResponseBody
    public boolean ceshi1(HttpServletRequest request) {
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            Date now = new Date();
            while (iter.hasNext()) {
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    System.out.println(myFileName);
                }
            }
        }
        return true;
    }


    @RequestMapping("/ceshi2")
    @ResponseBody
    public boolean ceshi2(ResourceVO resourceVO) {
        System.out.println("===="+resourceVO.toString());
        return true;
    }
    @RequestMapping("/ceshi3")
    @ResponseBody
    public boolean ceshi3(HttpServletRequest request) {
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            Date now = new Date();
            while (iter.hasNext()) {
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    System.out.println(myFileName);
                }
            }
        }
        return true;
    }
}
