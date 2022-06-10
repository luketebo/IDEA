package com.luketebo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class Home0610Application {

    public static void main(String[] args) {
        SpringApplication.run(Home0610Application.class, args);
    }

}
