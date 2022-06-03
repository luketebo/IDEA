package com.luketebo.service.impl;

import com.luketebo.dao.Stu;
import com.luketebo.doamin.Student;
import com.luketebo.service.stuSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class stuSerImpl implements stuSer {

    @Autowired
    private Stu stu;

    @Override
    public List<Student> getAll() {
        return stu.findAll();
    }
}
