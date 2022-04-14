package com.luketebo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luketebo.dao.BookDao;
import com.luketebo.domain.Book;
import com.luketebo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl2 implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public Boolean Save(Book book) {

        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean Update(Book book) {

        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean Delete(Integer id) {

        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getBookById(Integer id) {

        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {

        return bookDao.selectList(null);
    }

    @Override
    public IPage getPage(Integer page, Integer size) {
        IPage<Book> ipage = new Page<Book>(page, size);
        return bookDao.selectPage(ipage, null);
    }


}
