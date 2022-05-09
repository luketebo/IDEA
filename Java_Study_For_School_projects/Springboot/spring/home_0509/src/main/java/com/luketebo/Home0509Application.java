package com.luketebo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luketebo.mapper")
public class Home0509Application {

    public static void main(String[] args) {
        SpringApplication.run(Home0509Application.class, args);
    }

}
