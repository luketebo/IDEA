package com.luketebo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luketebo.entity.Student;
import com.luketebo.entity.Teacher;
import com.luketebo.mapper.TeacherMapper;
import com.luketebo.service.StudentService;
import com.luketebo.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
@Service

public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

}
