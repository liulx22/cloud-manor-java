package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.NurseVerificationMapper;
import com.buba.cloud.cloudManor.pojo.Image;
import com.buba.cloud.cloudManor.service.NurseVerificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class NurseVerificationServiceImpl implements NurseVerificationService {
    @Resource
    private NurseVerificationMapper nurseVerificationMapper;

    @Override
    public boolean VerificationInsert(Image image, Integer userId) {
        boolean b=nurseVerificationMapper.VerificationInsert(image);
        if(b=true){
            System.out.println(image.getId());
           boolean a= nurseVerificationMapper.InsertImgRlation(image,userId);
           return a;
        }else{
            return false;
        }

    }
}
