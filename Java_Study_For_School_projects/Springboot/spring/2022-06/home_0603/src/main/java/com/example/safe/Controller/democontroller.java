package com.example.safe.Controller;

import com.example.safe.Model.Student;
import com.example.safe.Model.Teacher;
import com.example.safe.Service.StudentService;
import com.example.safe.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class democontroller {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/")
    public String demo(){
        return "index";
    }

    @GetMapping("/login")
    public String log(){
        return "login/login";
    }

    @GetMapping("/detail/{type}/{path}")
    public String path(@PathVariable("type") String type, @PathVariable("path") String path){
        return "detail/" + type+ "/" +path;
    }

    @GetMapping("detail/student/stu")
    public String send(Model model){
        List<Student> list = studentService.list();
        model.addAttribute("students",list);
        return "detail/student/stu";
    }
    @GetMapping("detail/teacher/tea")
    public String sendt(Model model){
        List<Teacher> list = teacherService.list();
        model.addAttribute("teachers",list);
        return "detail/teacher/tea";
    }
}
