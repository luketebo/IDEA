package com.luketebo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.luketebo.entity.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface AuthorityMapper extends BaseMapper<Authority> {
    @Select("select a.* from s_user c,s_authority a,s_student_teacher ca where ca.student_id=c.id and ca.teacher_id=a.id and c.username=#{username}")
    public List<Authority> findAuthoritiesByUsername(String username);
}
