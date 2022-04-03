package com.luketebo.controller;

import com.luketebo.doamin.Student;
import com.luketebo.service.stuSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class stuCon {
    @Autowired
    private com.luketebo.service.stuSer stuSer;

    @GetMapping("/student")
    public String getStu(Model model){
        List<Student> data = stuSer.getAll();
        model.addAttribute("student",data);
        return "student";
    }

}
