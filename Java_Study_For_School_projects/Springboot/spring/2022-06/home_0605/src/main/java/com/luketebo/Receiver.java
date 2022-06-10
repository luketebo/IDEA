package com.luketebo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "luketebo")
public class Receiver {
    @RabbitHandler
    public void process(String in) {
        System.out.println("Receiver:" + in);
    }
}
