package com.luketebo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luketebo.entity.Student;
import com.luketebo.mapper.StudentMapper;
import com.luketebo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
