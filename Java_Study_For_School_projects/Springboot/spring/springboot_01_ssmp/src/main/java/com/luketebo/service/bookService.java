package com.luketebo.service;

import com.luketebo.domain.Book;

import java.util.List;

public interface bookService {
    Boolean Save(Book book);
    Boolean Update(Book book);
    Boolean Delete(Integer id);
    Book getBookById(Integer id);
    List<Book> getAll();
}
