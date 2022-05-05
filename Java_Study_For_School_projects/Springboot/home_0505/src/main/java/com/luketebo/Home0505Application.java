package com.luketebo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.luketebo.mapper")
@EnableCaching
public class Home0505Application {

    public static void main(String[] args) {
        SpringApplication.run(Home0505Application.class, args);
    }

}
