package com.luketebo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
//import com.luketebo.entity.Teacher;
//import com.luketebo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TeacherController {
//    @Autowired
//    private TeacherService teacherService;
//
//    @GetMapping("/teacher")
//    public String test_teacher(){
//        return "teacher";
//    }
//    @GetMapping("/getTeacher")
//    @ResponseBody
//    public Page<Teacher> getTeacher(@RequestParam int page){
//        System.out.println("访问第" + page + "页");
//        Page<Teacher> teacherPage = new Page<>((long)page, 8L);
//        this.teacherService.page(teacherPage);
//        return  teacherPage;
//    }
}
