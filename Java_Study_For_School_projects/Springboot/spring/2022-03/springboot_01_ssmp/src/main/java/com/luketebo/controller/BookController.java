package com.luketebo.controller;

import com.luketebo.domain.Book;
import com.luketebo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return iBookService.list();
    }

    @PostMapping
    public Boolean save(Book book){
        return iBookService.save(book);
    }

    @PutMapping()
    public Boolean update(@PathVariable Book book){
        return iBookService.update(book,null);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable String id){
        return iBookService.removeById(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable String id){
        return iBookService.getById(id);
    }

}

