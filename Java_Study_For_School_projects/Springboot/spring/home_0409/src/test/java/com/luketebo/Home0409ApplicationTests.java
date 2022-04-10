package com.luketebo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luketebo.dao.teacherDao;
import com.luketebo.entity.teacher;
import com.luketebo.service.teacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Home0409ApplicationTests {

    @Autowired
    private com.luketebo.dao.teacherDao teacherDao;
    @Test
    void contextLoads() {
    }
    @Test
    void findAllTeachers(){
        QueryWrapper<teacher> teacherQueryWrapper = new QueryWrapper<>();
//        teacherQueryWrapper.eq("id",1);
        teacherQueryWrapper.gt("id",20).select("name","number");
        List<teacher> teachers = teacherDao.selectList(teacherQueryWrapper);
        for (teacher teacher : teachers){
            System.out.println("teacher = " + teacher);

        }
    }
    @Test
    void editTeachers(){

    }
    @Test
    void insertTeachers(){

    }
    @Test
    void deleteTeachers(){

    }
    

}
