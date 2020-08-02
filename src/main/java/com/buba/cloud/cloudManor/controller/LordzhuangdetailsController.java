package com.buba.cloud.cloudManor.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.buba.cloud.cloudManor.pojo.Comment;
import com.buba.cloud.cloudManor.pojo.Image;
import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.service.CommentServive;
import com.buba.cloud.cloudManor.service.ImageService;
import com.buba.cloud.cloudManor.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.List;

@RequestMapping("Lordzhuangdetails")
@Controller
public class LordzhuangdetailsController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CommentServive commentServive;

    // 连接 Redis 数据库 , 获取连接对象
    Jedis jedis = new Jedis("127.0.0.1");


    /**
     * 功能描述:通过资源id查询资源信息，以及该资源的具体信息
     * @Param: [resourceId]
     * @Return: com.buba.cloud.cloudManor.pojo.Resource
     * @Author: zah
     * @Date: 2020/7/27 0027 15:04
     */
    @RequestMapping("resorceloader")
    @ResponseBody
    public  String selectResource(Integer resourceId){//获取前端resourceId
        //Integer resourceId=1;
        //判断资源id是否为空
        if (resourceId != null) {
            //获取资源信息
            Resource resource = resourceService.selectResourceType(resourceId);
            //如果资源信息不为null
            if(resource!=null){
                //获取资源类型
                String resourceType = resource.getReTypeCode();
                //如果资源类型不为null
                if (resourceType != null && !resourceType.equals("")) {
                    switch (resourceType) {
                        //如果类型为果树
                        case "fruiter":
                            resource.setResourceTreeDetail(resourceService.resourceFruiterMessage(resourceId));
                            return "success_jsonp("+JSONObject.toJSONString(resource)+")";
                           // return  resource;
                        //如果类型为畜牧
                        case "livestock":
                            resource.setResourceAnimalDetail(resourceService.resourceLivestockMessage(resourceId));
                            return "success_jsonp("+JSONObject.toJSONString(resource)+")";
                        //如果类型为地块
                        case "plot":
                            resource.setResourceGroundDetail(resourceService.resourcePlotMessage(resourceId));
                            return "success_jsonp("+JSONObject.toJSONString(resource)+")";
                    }
                }
                return null;
            }

        }
        //如果为空 返回null
        return null;
    }



    /**
     * 功能描述:点赞加+
     * @Param: [dianzan，userid]
     * @Return: com.buba.cloud.cloudManor.pojo.Resource
     * @Author: zah
     * @Date: 2020/7/27 0027 15:04
     */
    @RequestMapping("dianzan")
    @ResponseBody
    public String dianzan(String dianzan,Integer userid) {//获取前端参数uid

        //发布视频用户id
        String key = "likeCount" + userid;

        if (dianzan =="0") {
            jedis.set(key, dianzan);
            //点赞数＋1
            Long dian = jedis.incr(key);
            return "success_jsonp3(" + JSONObject.toJSONString(dian) + ")";
        } else {
            //点赞数＋1
            Long dian = jedis.incr(key);
            return "success_jsonp3(" + JSONObject.toJSONString(dian) + ")";
        }
    }



    /**
     * 功能描述:点赞减-
     * @Param: [userid]
     * @Return: com.buba.cloud.cloudManor.pojo.Resource
     * @Author: zah
     * @Date: 2020/7/27 0027 15:04
     */
    @RequestMapping("dcrdianzan")
    @ResponseBody
    public String dcrdianzan(Integer userid) {//获取前端参数uid
        //用户id
        String key = "likeCount" + userid;
        //自减数-1
        Long dian = jedis.decr(key);
        return "success_jsonp5(" + JSONObject.toJSONString(dian) + ")";
    }


    /**
     * 功能描述:查询点赞数
     * @Param: [userid]
     * @Return: String
     * @Author: zah
     * @Date: 2020/7/27 0027 15:04
     */
    @RequestMapping("selectDianZan")
    @ResponseBody
    public String selectDianZan(Integer userid){//-------获取前端参数uid
       // int uid=1;//前端资源中获取用户id
        String key="likeCount"+userid;
        String dian= jedis.get(key);
        System.out.println( "success_jsonp4("+JSONObject.toJSONString(dian)+")");
        return  "success_jsonp4("+JSONObject.toJSONString(dian)+")";

    }



    /**
     * 功能描述:头像回显
     * @Param: [userid]
     * @Return: String
     * @Author: zah
     * @Date: 2020/7/27 0027 15:04
     */
    @RequestMapping("findheadphoto")
    @ResponseBody
    public String findphoto(Integer userid){//头像回显-------获取前端uid
        Image img=imageService.findphoto(userid);
        if(img!=null){
            return   "success_jsonp2("+JSONObject.toJSONString(img)+")";
        }else {
            return null;
        }
    }

    /**
     * 功能描述:评论
     * @Param: [Integer userid,String content,Integer resourceId,Integer pid]
     * @Return: String
     * @Author: zah
     * @Date: 2020/7/27 0027 15:04
     */
    @RequestMapping("addComment")
    @ResponseBody
    public String comment(Integer userid,String content,Integer resourceId,Integer pid){//评论----------获取前端传来参数进行添加
        //添加
        int comment2=commentServive.addComment(userid,content,resourceId,pid);
        String commentSucess="评论成功！";
        String commentError="评论失败！";
        if(comment2!=0){
            return "success_jsonp7("+JSONObject.toJSONString(commentSucess)+")";
        }else {
            return "success_jsonp7("+JSONObject.toJSONString(commentError)+")";
        }
    }



    /**
     * 功能描述:查询回显评论
     * @Param: [resourceId]
     * @Return: String
     * @Author: zah
     * @Date: 2020/7/27 0027 15:04
     */
    @RequestMapping("huiXianComment")
    @ResponseBody
    public String  huiXianComment(Integer resourceId){//评论----------获取前端传来参数进行添加
        List<Comment> comment=commentServive.huiXianComment(resourceId);
        return   "success_jsonp6("+JSONObject.toJSONString(comment)+")";
    }


    /**
     * 功能描述:预览+
     * @Param: [String yuLan,Integer userid]
     * @Return: String
     * @Author: zah
     * @Date: 2020/7/27 0027 15:04
     */
    @RequestMapping("yuLan")
    @ResponseBody
    public String yuLan(String yuLan,Integer userid) {//-------获取前端参数uid
        //发布视频用户id
        String key = "yuLanCount" + userid;
        if (yuLan =="0") {
            jedis.set(key, yuLan);
            //预览数＋1
            Long dian = jedis.incr(key);
            return "success_jsonpYuLan(" + JSONObject.toJSONString(dian) + ")";
        } else {
            //预览数＋1
            Long dian = jedis.incr(key);
            return "success_jsonpYuLan(" + JSONObject.toJSONString(dian) + ")";
        }
    }


    /**
     * 功能描述:查询点赞数
     * @Param: [Integer userid]
     * @Return: String
     * @Author: zah
     * @Date: 2020/7/27 0027 15:04
     */
    @RequestMapping("selectYuLan")
    @ResponseBody
    public String selectYuLan(Integer userid){//-------获取前端参数uid
        String key="yuLanCount"+userid;
        String dian= jedis.get(key);
        System.out.println( "success_jsonpSelectYuLan("+JSONObject.toJSONString(dian)+")");
        return  "success_jsonpSelectYuLan("+JSONObject.toJSONString(dian)+")";
    }


}