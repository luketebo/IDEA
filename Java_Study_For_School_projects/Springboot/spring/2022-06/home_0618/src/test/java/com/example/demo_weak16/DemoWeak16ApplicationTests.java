package com.example.demo_weak16;

import com.example.demo_weak16.service.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoWeak16ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private EmailService emailService;

    @Test
    public void sendSimpleEmail(){
        String content = "祝福虽好，但是元旦节还有197天";
        emailService.sendSimpleMail("1171158460@qq.com","祝福邮件",content);
    }

    @Test
    public void sendMimeEmail(){
        String content = "<a href='https://baidu.com'>你好，欢迎注册网站，请点击链接激活</a>";
        emailService.sendHtmlMail("1171158460@qq.com","激活邮件",content);
    }

    @Test
    public void sendHtmlMail2(){
        emailService.sendHtmlMail2("1171158460@qq.com", "附件","好东西");

    }

//    @Test
//    public void sendAttachment(){
//        emailService.sendAttachmentsMail("979176587@qq.com","附件","色图","E:/Hashimoto.jpg");
//    }
}
