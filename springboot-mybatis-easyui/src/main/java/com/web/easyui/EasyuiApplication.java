package com.web.easyui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.web.easyui")
public class EasyuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyuiApplication.class, args);
    }

}
