package com.djy.garbageclassification;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.djy.garbageclassification.mapper")
public class GarbageClassificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GarbageClassificationApplication.class, args);
    }

}
