package com.luketebo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luketebo.entity.student;

public interface studentService extends IService<student> {
    student getOne(Integer id);
}




