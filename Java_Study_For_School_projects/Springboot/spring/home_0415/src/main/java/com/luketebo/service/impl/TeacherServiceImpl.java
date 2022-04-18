package com.luketebo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luketebo.dao.TeacherDao;
import com.luketebo.entity.Teacher;
import com.luketebo.service.TeacherService;
import org.springframework.stereotype.Service;


@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, Teacher> implements TeacherService {

}
