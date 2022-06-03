package com.luketebo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luketebo.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherDao extends BaseMapper<Teacher> {
}
