package com.luketebo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luketebo.domain.Book;

import java.util.List;

public interface BookService {
    Boolean Save(Book book);
    Boolean Update(Book book);
    Boolean Delete(Integer id);
    Book getBookById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(Integer page, Integer size);
}
