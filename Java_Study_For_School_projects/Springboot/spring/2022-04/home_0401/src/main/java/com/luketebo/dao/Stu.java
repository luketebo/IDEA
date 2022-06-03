package com.luketebo.dao;


import com.luketebo.doamin.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Stu {
    // 查询
    @Select("select * from students")
    public List<Student> findAll();
    @Insert("insert into students (id, name, age) value (4, 'zhou', 21)")
    public void insertData();
    @Delete("delete from students where id = 4")
    public void deleteData();
    @Update("update students set name = 'yang' where id = 3")
    public void updateData();
}
