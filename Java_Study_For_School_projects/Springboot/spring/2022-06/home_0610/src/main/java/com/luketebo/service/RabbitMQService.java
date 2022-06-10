package com.luketebo.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
    @RabbitListener(queues = "fanout_queue_email")
    public void psubConsumerEmail(Message message) {
        byte[] body = message.getBody();
        String s = new String(body);
        System.out.println(s);
    }
    @RabbitListener(queues = "fanout_queue_sms")
    public void psubConsumerSms(Message message) {
        byte[] body = message.getBody();
        String s = new String(body);
        System.out.println(s);
    }
}
