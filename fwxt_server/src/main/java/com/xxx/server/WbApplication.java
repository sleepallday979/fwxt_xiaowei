package com.xxx.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: tsd
 * @Date: 2021/5/29 18:17
 */
@SpringBootApplication
@MapperScan("com.xxx.server.mapper")
public class WbApplication {
    public static void main(String[] args){
        SpringApplication.run(WbApplication.class,args);
    }
}
