package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.Image;

public interface NurseVerificationService {

    boolean VerificationInsert(Image image, Integer userId);
}
