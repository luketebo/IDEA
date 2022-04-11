package com.luketebo.service.impl;

import com.luketebo.domain.Book;
import com.luketebo.service.bookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookServiceImpl implements bookService {
    @Override
    public Boolean Save(Book book) {
        return null;
    }

    @Override
    public Boolean Update(Book book) {
        return null;
    }

    @Override
    public Boolean Delete(Integer id) {
        return null;
    }

    @Override
    public Book getBookById(Integer id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }
}
