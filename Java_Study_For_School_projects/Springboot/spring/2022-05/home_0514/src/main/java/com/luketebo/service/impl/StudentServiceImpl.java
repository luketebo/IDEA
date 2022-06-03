package com.luketebo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.luketebo.mapper.StudentMapper;
import com.luketebo.model.Student;
import com.luketebo.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wp
 * @since 2022-04-12
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public Student getOne(Integer id) {
        StudentMapper studentMapper = this.getBaseMapper();
        Student student = studentMapper.selectById(id);
        return student;
    }
}
