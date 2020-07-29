package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.Agriculture;
import com.buba.cloud.cloudManor.pojo.AgricultureOperation;
import com.buba.cloud.cloudManor.service.ResourceDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* User: 智慧
 * \* Date: 2020/7/28
 * \* Time: 18:16
 * \* 模块:资源详情
 * \
 */
@RequestMapping("resource")
@Controller
public class ResourceDetailsController {
    @Resource
    private ResourceDetailsService resourceDetailsService;
    /*农事记录*/
    @RequestMapping("getAgriculture")
    @ResponseBody
    public Agriculture getAgriculture(int id){
        Agriculture a = resourceDetailsService.GETAgriculture(id);
        return a;
    }
    /*养护记录*/
    @RequestMapping("getAgricultureOperation")
    @ResponseBody
    public List<AgricultureOperation> getAgricultureOperation(int id){
        List<AgricultureOperation> list= resourceDetailsService.GETAgricultureOperation(id);
        return list;
    }
}
