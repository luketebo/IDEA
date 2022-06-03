package com.luketebo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luketebo.entity.teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface teacherDao extends BaseMapper<teacher> {
}
