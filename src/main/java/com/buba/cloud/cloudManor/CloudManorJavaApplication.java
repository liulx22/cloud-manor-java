package com.buba.cloud.cloudManor;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.buba.cloud.cloudManor.mapper")
@SpringBootApplication
public class CloudManorJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudManorJavaApplication.class, args);
    }

}
