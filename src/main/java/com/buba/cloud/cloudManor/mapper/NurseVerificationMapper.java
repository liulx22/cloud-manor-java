package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.Image;
import io.lettuce.core.dynamic.annotation.Param;

public interface NurseVerificationMapper {
    boolean VerificationInsert(Image image);

    boolean InsertImgRlation(@Param("image") Image image, @Param("userId") Integer userId);
}
