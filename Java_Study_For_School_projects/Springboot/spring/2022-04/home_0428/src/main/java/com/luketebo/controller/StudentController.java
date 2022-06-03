package com.luketebo.controller;



import com.luketebo.entity.student;
import com.luketebo.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private com.luketebo.service.studentService studentService;
    @GetMapping("student")
    public String list(Model model) {
        List<student> list = studentService.list();
        model.addAttribute("student", list);
        return "stulist";
    }

    @GetMapping("addstu")
    public String addstu() {
        return "addstu";
    }

    @PostMapping("save")
    public String save(student student) {
        studentService.save(student);
        return "redirect:/student";
    }
    @GetMapping("delstu")
    public String delstu(Integer id) {
        studentService.removeById(id);
        return "redirect:/student";
    }
    @GetMapping("updatestu")
    public String updatestu(Integer id, Model model) {
        student student = studentService.getById(id);
        com.luketebo.entity.student one = studentService.getOne(id);
        model.addAttribute("student", one);
        return "updatestu";
    }

    @PostMapping("updatestu")
    public String update(student studen){
        studentService.updateById(studen);
        return  "redirect:/student";
    }
}
