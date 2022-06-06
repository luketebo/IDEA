package com.luketebo;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class Home0605ApplicationTests {

    @Autowired
    private Sender sender;

    @Before
    public void before() throws Exception {
        System.out.println("Start sending messages...");
    }

    @After
    public void after() throws Exception {
        System.out.println("Done sending messages...");
    }

    @Test
    public void testSend() throws Exception {
        sender.send();
    }

    @Test
    public void contextLoads() {
    }
}


