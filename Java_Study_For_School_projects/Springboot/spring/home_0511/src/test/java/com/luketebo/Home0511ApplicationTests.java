package com.luketebo;

import com.luketebo.service.PeopleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Home0511ApplicationTests {

    @Autowired
    private PeopleService peopleService;
    @Test
    void contextLoads() {

    }

}
