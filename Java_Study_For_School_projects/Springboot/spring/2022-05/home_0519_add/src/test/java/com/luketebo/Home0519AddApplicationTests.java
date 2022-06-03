package com.luketebo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class Home0519AddApplicationTests {

    @Test
    void contextLoads() {
        BCryptPasswordEncoder ecode = new BCryptPasswordEncoder();  // 加密机制
        String encode = ecode.encode("123456");
        System.out.println(encode);
    }

}
