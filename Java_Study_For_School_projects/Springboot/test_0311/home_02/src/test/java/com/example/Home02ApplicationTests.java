package com.example;

import com.example.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Home02ApplicationTests {
    @Autowired
    private Student student;
    @Test
    void contextLoads() {
        System.out.println(student);
    }

}
