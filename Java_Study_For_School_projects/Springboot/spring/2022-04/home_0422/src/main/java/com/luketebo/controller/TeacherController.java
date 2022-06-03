package com.luketebo.controller;

import com.luketebo.entity.Teacher;
import com.luketebo.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Api("TeacherController")
public class TeacherController {
    @GetMapping("teachers")
    public Result teacherList(){
        Teacher zhangSan = new Teacher(1, "zhangSan", 12);
        Teacher lisi = new Teacher(2, "lisi", 21);
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(zhangSan);
        teachers.add(lisi);
        return new Result(200, "success", teachers);
    }
    @GetMapping("teacher/{id}")
    public Result getTeacher(@PathVariable Integer id){
        // 根据id做查询
        System.out.println(id);
        return new Result<>(200, "success", new Teacher(1,"zhangSan", 12));
    }
    @PostMapping("teacher/{id}")
    public Result addTeacher(@PathVariable Integer id, @RequestBody Teacher teacher){
        // 将数据插入数据库
        System.out.println(teacher);
        return  new Result(200, "success", true);
    }
    @PutMapping("teacher/{id}")
    public Result updateTeacher(@PathVariable Integer id, @RequestBody Teacher teacher){
        // 根据id更新数据
        System.out.println("update" + teacher);
        return  new Result(200, "success", true);
    }
    @DeleteMapping("teacher/{id}")
    public Result deleteTeacher(@PathVariable Integer id){
        // 根据id删除数据
        System.out.println("delete" + id);
        return  new Result(200, "success", true);
    }
}

