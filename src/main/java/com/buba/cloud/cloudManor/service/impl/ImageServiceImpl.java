package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.ImageMapper;

import com.buba.cloud.cloudManor.pojo.Image;
import com.buba.cloud.cloudManor.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;

    @Override
    public Image findphoto(int userid) {
        return imageMapper.findphoto(userid);
    }
}
