package com.luketebo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luketebo.entity.Student;
import com.luketebo.mapper.StudentMapper;
import com.luketebo.service.StudentService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Override
    @Cacheable(cacheNames = "student", key = "#id")
    public Student getOne(Integer id) {
        return this.getBaseMapper().selectById(id);
    }
}
