package com.luketebo;

import com.luketebo.dao.StudentDao;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class Home0407ApplicationTests {
    @Autowired
    private StudentDao studentDao;

    @Test
    void FindAll(){
        studentDao.selectList(null);

    }

    @Test
    void contextLoads() {
    }

}
