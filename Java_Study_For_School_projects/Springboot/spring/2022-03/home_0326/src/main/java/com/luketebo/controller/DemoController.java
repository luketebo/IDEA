package com.luketebo.controller;


import com.luketebo.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class DemoController {
    @GetMapping("/main")
    public String demo(Model model){
        ArrayList<Teacher> teacher = new ArrayList<>();
        teacher.add(new Teacher(1,"汪",25,"老师"));
        teacher.add(new Teacher(2,"杨",45,"教授"));
        teacher.add(new Teacher(3,"肖",36,"院长"));
        model.addAttribute("tea",teacher);
        return "main";
    }
    @GetMapping("/t1")
    public String test(Model model){
        ArrayList<Teacher> teacher = new ArrayList<>();
        teacher.add(new Teacher(1,"汪",25,"老师"));
        teacher.add(new Teacher(2,"杨",45,"教授"));
        teacher.add(new Teacher(3,"肖",36,"院长"));
        model.addAttribute("tea",teacher);
        return "t1";
    }


}
