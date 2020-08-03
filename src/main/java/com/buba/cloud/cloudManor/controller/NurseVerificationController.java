package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.Image;
import com.buba.cloud.cloudManor.service.NurseVerificationService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Authentication")
public class NurseVerificationController {
    @Autowired
    private NurseVerificationService nurseVerificationService;
    @RequestMapping("NurseVerification")
    public boolean NurseVerification(Integer userId, MultipartFile cardzheng, MultipartFile cardfan, MultipartFile shouchi) throws IOException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String filename = sdf.format(new Date());
        //身份正前缀
        String f = 1 + "_" + filename + "_01";
        //身份反前缀
        String f1 = 1 + "_" + filename + "_02";
        //手持身份前缀
        String f2 = 1 + "_" + filename + "_03";
        //图片存放地址
        String a="https://lzj-picservice.oss-cn-beijing.aliyuncs.com/CloudManor_Pic";
        List<File> files = new ArrayList<>();
        //身份正后缀
        String fileName = cardzheng.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        //身份反后缀
        String fileName1 = cardfan.getOriginalFilename();
        String suffix1 = fileName1.substring(fileName1.lastIndexOf("."), fileName1.length());
        //头像后缀
        String fileName2 = shouchi.getOriginalFilename();
        String suffix2 = fileName2.substring(fileName2.lastIndexOf("."), fileName2.length());


        //处理身份正
        File file1=new File(f+suffix);
        FileUtils.copyInputStreamToFile(cardzheng.getInputStream(), file1);
        //身份反
        File file2=new File(f1+suffix1);
        FileUtils.copyInputStreamToFile(cardfan.getInputStream(), file2);
        //头像
        File file3=new File(f2+suffix2);
        FileUtils.copyInputStreamToFile(shouchi.getInputStream(), file3);

        files.add(file1);
        files.add(file2);
        files.add(file3);

        //OSSUtils.putUpload(files);

        Image image=new Image();
        image.setImgName(f+suffix);
        image.setImgDir(a);
        image.setTypeCode("user_identity");

        //添加养护人信息
        boolean b=nurseVerificationService.VerificationInsert(image,userId);
        Image image1=new Image();
        image1.setImgName(f+suffix);
        image1.setImgDir(a);
        image1.setTypeCode("user_identity");
        boolean b1=nurseVerificationService.VerificationInsert(image1,userId);

        Image image2=new Image();
        image2.setImgName(f2+suffix);
        image2.setImgDir(a);
        image2.setTypeCode("user_identity");
        boolean b2=nurseVerificationService.VerificationInsert(image2,userId);
        if(b==true|b1==true|b2==true){
            return true;
        }else {
            return false;
        }


    }


}
