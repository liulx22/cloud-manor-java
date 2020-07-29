package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.UserAttentionVo;
import com.buba.cloud.cloudManor.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 */
import java.util.List;

@Controller
@RequestMapping("attention")
public class AttentionController {
    @Autowired
    private AttentionService attentionService;
    @RequestMapping("SelAttrntion")
    @CrossOrigin
    @ResponseBody
    public List<UserAttentionVo> SelAttrntion(){
        List<UserAttentionVo> userAttentionVos = attentionService.SelAttrntion();
        System.out.println(userAttentionVos.toString());
        return userAttentionVos;
    }
    //关注
    @ResponseBody
    @CrossOrigin
    @RequestMapping("Attrntion")
    public boolean Attrntion(Integer userId) {
        boolean attrntion = attentionService.Attrntion(userId);
        if (attrntion==true){
            return  true;
        }else {
            return false;
        }

    }
    //取消关注
    @ResponseBody
    @CrossOrigin
    @RequestMapping("CancelTheAttention")
    public boolean CancelTheAttention(Integer userId) {
        System.out.println(userId);
        boolean b = attentionService.CancelTheAttention(userId);
        if (b==true){
            return true;
        }else {
            return false;
        }

    }
}
