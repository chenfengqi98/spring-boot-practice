package com.demo.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
public class DemoEmpServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEmpServiceApplication.class, args);
    }

}
