package Cs.SpringBoot.AssignMent.controller;

import java.util.List;

import Cs.SpringBoot.AssignMent.entity.Assignment;
import Cs.SpringBoot.AssignMent.entity.Work;
import Cs.SpringBoot.AssignMent.service.AssignmentService;
import Cs.SpringBoot.AssignMent.service.StudentInfoService;
import Cs.SpringBoot.AssignMent.service.WorkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import Cs.SpringBoot.AssignMent.entity.StudentInfo;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FrontEndController {

    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private WorkService workService;

    @GetMapping("/teacher")
    public String teacher(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        Page<StudentInfo> page = new Page<>(pn, 14);
        studentInfoService.page(page, null);
        boolean next = page.hasNext();
        model.addAttribute("next", next);
        boolean previous = page.hasPrevious();
        model.addAttribute("previous", previous);
        List<StudentInfo> records = page.getRecords();

        model.addAttribute("stu", records);
        long now = page.getCurrent();
        model.addAttribute("now", now);

        return "Teacher/teacher";
    }

    @GetMapping("/gaiNan")
    public String gaiNan(Model model)
    {
        List<StudentInfo> stu = studentInfoService.list();
        model.addAttribute("stu", stu);

        return "Teacher/teacherGaiNan";
    }

    @GetMapping("/chaKan")
    public String chaKan() {
        return "/Teacher/teacherChaKan";
    }
    @PostMapping("/update")
    public String updates(@RequestBody StudentInfo studentInfo) {
        studentInfoService.updateById(studentInfo);
        return "redirect:/teacher";
    }

    @PostMapping("/addstu")
    public String addstu(@RequestBody StudentInfo studentInfo) {
        System.out.println(studentInfo);
        System.out.println(studentInfo.getClass());
        studentInfoService.save(studentInfo);
//        return type(studentInfo);
        return "redirect:/teacher";
    }

    @GetMapping("/delstu")
    public String delstu(@RequestParam Integer id) {
        System.out.println(id);
        studentInfoService.removeById(id);
        System.out.println(studentInfoService.list());
        return "redirect:/teacher";
    }

    /*
     * 返回老师管理页面的相关内容
     */
    @GetMapping("/createAs")
    public String createAssignment() {
        return "/Teacher/createAs";
    }

    @GetMapping("/checkAs")
    public String checkAssignment() {
        return "/Teacher/checkAs";
    }

    @GetMapping("/readAs")
    @Deprecated
    public String readAssignment() {
        return "/Teacher/readAs";
    }

    @GetMapping("/createCl")
    public String createCl() {
        return "/Teacher/createCl";
    }


    /**
     * 学生主页面
     *
     * @param model
     * @return
     */
    @GetMapping("/student")
    public String student(Model model) {
        return "Student/student";
    }

    /**
     * 学生作业
     *
     * @return
     */
    @GetMapping("assignmentList")
    public String assignmentList(Model model) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // 学生的班级
        StudentInfo studentInfo = studentInfoService.getOne(new QueryWrapper<StudentInfo>()
                .last("limit 1")
                .eq("name", principal.getUsername()));
        List<Assignment> assignmentList = null;
        if (null != studentInfo) {
            Integer classId = studentInfo.getClassId();
            assignmentList = assignmentService.list(new QueryWrapper<Assignment>().eq("class_id", classId));
        }

        model.addAttribute("assignmentList", assignmentList);
        return "Student/assignmentList";
    }

    /**
     * 提交作业
     * @param work
     * @return
     */
    @PostMapping("workSubmit")
    @ResponseBody
    public String workSubmit(Work work) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        work.setStudentName(principal.getUsername());
        workService.save(work);
        return "success";
    }

    /**
     * 我提交的作业
     * @param model
     * @return
     */
    @GetMapping("workList")
    public String workList(Model model) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Work> workList = workService.list(new QueryWrapper<Work>().eq("student_name", principal.getUsername()));;
        model.addAttribute("workList", workList);
        return "Student/workList";
    }
}
