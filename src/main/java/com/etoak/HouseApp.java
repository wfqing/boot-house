package com.etoak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wfqing on 2020/4/20.
 */

@SpringBootApplication
@MapperScan(basePackages = "com.etoak.mapper")

//eclipse
//idea
/////9898
//999990
////////////////////
//p

public class HouseApp {
    public static void main(String[] agrs) {
        SpringApplication.run(HouseApp.class, agrs);
    }
}
