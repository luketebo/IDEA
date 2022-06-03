package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Student;
import com.example.mapper.StudentMapper;
import com.example.service.StudentService;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
