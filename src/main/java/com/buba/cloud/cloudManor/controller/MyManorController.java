package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.service.MyManorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MyManorController
 * @Description
 * @Created by Administrator on 2020/7/24 15:30
 * @Version 1.0
 **/
@RestController
@RequestMapping("/myManor")
public class MyManorController {

    @Autowired
    private MyManorService myManorService;

}
