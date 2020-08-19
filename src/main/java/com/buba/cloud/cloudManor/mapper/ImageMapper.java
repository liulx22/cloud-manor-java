package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ImageMapper {
    Image findphoto(@Param("uid") int userid);

    Image findResoursePhoto(@Param("resourceId")Integer resourceId);
}
