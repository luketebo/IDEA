package com.luketebo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luketebo.domain.Book;
import com.luketebo.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot01SsmpApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
    }
    @Test
    void testPage(){
        IPage<Book> page = bookService.getPage(2, 5);
        System.out.println(page.getRecords());
    }
}
