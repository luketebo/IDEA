package com.luketebo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luketebo.entity.student;
import com.luketebo.mapper.StudentMapper;
import com.luketebo.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

@Service
public class studentServiceImpl extends ServiceImpl<StudentMapper, student> implements studentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public student getOne(Integer id) {
//        studentMapper.selectById(id);
        student stu = this.getBaseMapper().selectById(id);
        return stu;
    }
}
