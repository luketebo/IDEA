package com.luketebo.controller;

//import com.sun.org.apache.xpath.internal.operations.Mod;

import com.luketebo.model.Student;
import com.luketebo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Value("${photo.file.dir}")
    private String realpath;

    @GetMapping("student")
    public String list(Model model) {
        List<Student> students = studentService.list();
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("addstu")
    public String addstu() {
        return "student/add";
    }

    //图像上传
    private String uploadPhoto(MultipartFile img, String originalFilename) throws IOException {
        String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = fileName + ext;
        img.transferTo(new File(realpath, newFilename));
        return newFilename;
    }

    @PostMapping("save")
    public String save(Student student,MultipartFile img) throws IOException {
        String originalFilename = img.getOriginalFilename();
        String newFilename = uploadPhoto(img, originalFilename);
        student.setPhoto(newFilename);
        studentService.save(student);

        return "redirect:/student";
    }

    @GetMapping("delstu")
    public String delstu(Integer id) {
        studentService.removeById(id);
        return "redirect:/student";
    }

    @GetMapping("updatestu")
    public String update(Integer id, Model model) {
        Student stu = studentService.getOne(id);
        model.addAttribute("student", stu);
        return "student/update";
    }

    @PostMapping("update")
    public String updatestu(Student student,MultipartFile img) throws IOException {
        String originalFilename = img.getOriginalFilename();
        String newFilename = uploadPhoto(img, originalFilename);
        student.setPhoto(newFilename);
        studentService.updateById(student);
        return "redirect:/student";
    }
}
