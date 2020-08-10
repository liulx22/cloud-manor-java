package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.AgricultureOperationMapper;
import com.buba.cloud.cloudManor.pojo.AgricultureOperation;
import com.buba.cloud.cloudManor.pojo.Image;
import com.buba.cloud.cloudManor.pojo.ImgRlation;
import com.buba.cloud.cloudManor.service.AgricultureOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgricultureOperationServiceImpl  implements AgricultureOperationService {

    @Autowired
    private AgricultureOperationMapper  agricultureOperationMapper;

    @Override
    @Transactional
    public boolean addAgricultureOperation(AgricultureOperation agricultureOperation) {
        boolean b = agricultureOperationMapper.addAgricultureOperation(agricultureOperation);
      /*  Image image = new Image();
        image.setImgDir(uploadUrl);
        boolean b1 = agricultureOperationMapper.addImage(image);
        if(b1){
            ImgRlation imgRlation = new ImgRlation();
            imgRlation.setImageId(image.getId());
            imgRlation.setOtherId(agricultureOperation.getId());
            agricultureOperationMapper.addImgRlation(imgRlation);
        }
        Image image1 = new Image();
        image1.setImgDir(videUrl);
        boolean b2 = agricultureOperationMapper.addImage(image);
        if(b){
            ImgRlation imgRlation = new ImgRlation();
            imgRlation.setImageId(image.getId());
            imgRlation.setOtherId(agricultureOperation.getId());
            agricultureOperationMapper.addImgRlation(imgRlation);
        }*/
        return b;
    }

    @Override
    public boolean mainImgadd(Image image, Integer resourceid) {
        boolean b=false;
        //上传图片表
        boolean a =agricultureOperationMapper.addImage(image);
        if (a){
            //上传图片中间表
            Image img=new Image();

           ImgRlation imr=new ImgRlation();
            imr.setTypeCode(11);
            imr.setOtherId(resourceid);
            imr.setImageId(img.getId());
            b=agricultureOperationMapper.addImgRlation(imr);
        }
        return b;
    }

}
