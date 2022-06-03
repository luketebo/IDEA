package com.luketebo.dao;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luketebo.doamin.Classes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@TableName("classes")
public interface Cla extends BaseMapper<Classes> {

}
