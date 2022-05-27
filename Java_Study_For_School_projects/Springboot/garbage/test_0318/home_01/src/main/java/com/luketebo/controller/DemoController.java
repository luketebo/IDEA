package com.luketebo.controller;

import com.luketebo.model.Student;
import com.luketebo.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class DemoController {
    @GetMapping("/student")
    public String test(Model model){
        ArrayList<Student> stu = new ArrayList<Student>();
        stu.add(new Student(1,"zhangSan",20,"学生"));
        stu.add(new Student(2,"liSi",19,"菜鸡"));
        stu.add(new Student(3,"wangWu",21,"大牛"));
        model.addAttribute("stu",stu);
        return "student";
    }
    @GetMapping("/teacher")
    public String demo(Model model){
        ArrayList<Teacher> teacher = new ArrayList<>();
        teacher.add(new Teacher(1,"汪",25,"老师"));
        teacher.add(new Teacher(2,"杨",45,"教授"));
        teacher.add(new Teacher(3,"肖",36,"院长"));
        model.addAttribute("tea",teacher);
        return "teacher";
    }

}
