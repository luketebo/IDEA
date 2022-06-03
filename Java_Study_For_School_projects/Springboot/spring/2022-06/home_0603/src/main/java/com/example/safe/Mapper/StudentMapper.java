package com.example.safe.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.safe.Model.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
