package com.luketebo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luketebo.domain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao extends BaseMapper<Student> {
}
