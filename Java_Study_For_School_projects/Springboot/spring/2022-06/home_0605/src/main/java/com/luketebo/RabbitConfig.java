package com.luketebo;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {
    public static final String QUEUENAME = "luketebo";

    @Bean
    public Queue helloQueue() {
        return new Queue(QUEUENAME);
    }
}
