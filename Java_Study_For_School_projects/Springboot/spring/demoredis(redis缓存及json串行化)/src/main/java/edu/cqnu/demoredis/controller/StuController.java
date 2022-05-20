package edu.cqnu.demoredis.controller;

import edu.cqnu.demoredis.model.Student;
import edu.cqnu.demoredis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StuController {
    @Autowired
    private StudentService studentService;

    @GetMapping("getstu/{id}")
    public Student stu(@PathVariable Integer id){
        Student student = studentService.getOne(id);
        return student;
    }

    @GetMapping("update/{id}")
    public Student update(@PathVariable Integer id){
        Student stu = studentService.myUpdate(id);
        return stu;
    }

    @GetMapping("delete/{id}")
    public int delete(@PathVariable Integer id){
        int flag = studentService.myDelete(id);
        return flag;
    }

    @GetMapping("all")
    public List<Student> all(){
        return studentService.list();
    }
}
