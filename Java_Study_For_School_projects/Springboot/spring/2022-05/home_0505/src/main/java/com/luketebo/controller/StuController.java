package com.luketebo.controller;

import com.luketebo.entity.Student;
import com.luketebo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuController {
    @Autowired
    private StudentService studentService;
    @GetMapping("getStu/{id}")
    public Student getStu(@PathVariable Integer id) {
        Student stu = studentService.getOne(id);
        return stu;
    }
}
