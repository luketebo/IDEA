package com.luketebo.controller;

import com.luketebo.entity.Student;
import com.luketebo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    // 通过student 这个访问路径访问student.html
    @GetMapping("student")
    public String student(Model model) {
        // 获取数据库中全部数据
        List<Student> list =  studentService.list();
        // 将数据库中数据传递给student.html
        model.addAttribute("student", list);
        return "student";
    }
    @GetMapping("student-edit")
    public String student_edit(Integer id, Model model){
        Student student = studentService.getOne(id); // 获取id 然后把数据传递给student-edit.html
        model.addAttribute("student", student);
        return "student-edit";
    }
    @GetMapping("student-add")
    public String student_add(){
        return "student-add";
    }
    @GetMapping("student-del")
    public String student_del(){
        return "student-del";
    }
    @PostMapping("save")
    public String save(Student student){
        studentService.save(student);
        return "redirect:student";
    }
    @PostMapping("update")  // 更新
    public String update(Student student){
        studentService.updateById(student);
        System.out.println("update---------->"+student);
        return "redirect:student";
    }
    @GetMapping("del")
    public String del(Integer id){
        studentService.removeById(id);
        return "redirect:student";
    }





}
