package Cs.SpringBoot.AssignMent.controller;

import java.io.IOException;
import java.util.List;

import Cs.SpringBoot.AssignMent.entity.StudentInfo;
import Cs.SpringBoot.AssignMent.entity.TeacherInfo;
import Cs.SpringBoot.AssignMent.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * <p>
 * 学生表 前端控制器
 * </p>
 *
 * @author Dog
 * @since 2022-06-12 09:06:33
 */
@Controller
@RequestMapping("/AssignMent/student")
public class StudentInfoController {
    @Autowired
    private StudentInfoService studentInfoService;

    @GetMapping("/admin")
    public String student(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        Page<StudentInfo> page = new Page<>(pn,9);
        studentInfoService.page(page, null);
        boolean next = page.hasNext();//是否有下一页
        model.addAttribute("next",next);
        boolean pre = page.hasPrevious();//是否有上一页
        model.addAttribute("previous",pre);
        List<StudentInfo> l = page.getRecords();//获得的记录
        model.addAttribute("students",l);
        long now = page.getCurrent();//现在在哪一页
        model.addAttribute("now", now);
        return "admin/admin_student";
    }

    @PostMapping("/save")
    public String save(StudentInfo studentInfo){
        studentInfoService.save(studentInfo);
        return "redirect:/AssignMent/student/admin";
    }

    @PostMapping("/update")
    public String updates(StudentInfo student){
        studentInfoService.updateById(student);
        return "redirect:/AssignMent/student/admin";
    }

    @GetMapping("delstu")
    public String delstu(Integer id){
        studentInfoService.removeById(id);
        return "redirect:/AssignMent/student/admin";
    }
}
