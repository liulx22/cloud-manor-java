package com.buba.cloud.cloudManor.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiOSSInfoDTO implements Serializable {
    private String securityToken;
    private String accessKeyId;
    private String accessKeySecret;
    private String expiration;
    private String callbackHost;
    private String callbackUrl;
    private String postPolicy;
    private String bucketName;
    private String dir;
    private String endopint;

    @Override
    public String toString() {
        return "ApiOSSInfoDTO{" +
                "securityToken='" + securityToken + '\'' +
                ", accessKeyId='" + accessKeyId + '\'' +
                ", accessKeySecret='" + accessKeySecret + '\'' +
                ", expiration='" + expiration + '\'' +
                ", callbackHost='" + callbackHost + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", postPolicy='" + postPolicy + '\'' +
                ", bucketName='" + bucketName + '\'' +
                ", dir='" + dir + '\'' +
                ", endopint='" + endopint + '\'' +
                '}';
    }
}
