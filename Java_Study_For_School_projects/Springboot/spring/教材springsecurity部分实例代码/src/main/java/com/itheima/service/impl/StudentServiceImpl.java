package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.domain.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
