package com.buba.cloud.cloudManor.mapper;


import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.ResourceAnimalDetail;
import com.buba.cloud.cloudManor.pojo.ResourceGroundDetail;
import com.buba.cloud.cloudManor.pojo.ResourceTreeDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


/**
 * @ProjectName: cloud-manor-java
 * @Package: com.buba.cloud.cloudManor.mapper
 * @ClassName: ResourceMapper
 * @Author: ggx
 * @Description:
 * @Date: 2020/7/26 0026 12:56
 * @Version: 1.0
 */

@Repository
public interface ResourceMapper extends Mapper<Resource> {
    Resource selectLardResource();

    Resource selectResourceType(@Param("resourceId") Integer resourceId);

    ResourceTreeDetail resourceFruiterMessage(@Param("resourceId") Integer resourceId);

    ResourceAnimalDetail resourceLivestockMessage(@Param("resourceId") Integer resourceId);

    ResourceGroundDetail resourcePlotMessage(@Param("resourceId") Integer resourceId);
}
