package com.luketebo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luketebo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
