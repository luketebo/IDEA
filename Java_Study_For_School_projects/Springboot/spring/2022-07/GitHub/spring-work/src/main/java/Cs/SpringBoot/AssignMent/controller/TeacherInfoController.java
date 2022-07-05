package Cs.SpringBoot.AssignMent.controller;

import java.util.List;

import Cs.SpringBoot.AssignMent.entity.TeacherInfo;
import Cs.SpringBoot.AssignMent.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import Cs.SpringBoot.AssignMent.service.ClassInfoService;

/**
 * <p>
 * 老师表 前端控制器
 * </p>
 *
 * @author Dog
 * @since 2022-06-12 09:06:33
 */
@Controller
@RequestMapping("/AssignMent/teacher")
public class TeacherInfoController {

    @Autowired
    private TeacherInfoService teacherInfoService;

    @Autowired
    private ClassInfoService classInfoService;

    @GetMapping("admin")
    public String teacher(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        Page<TeacherInfo> page = new Page<>(pn,9);
        teacherInfoService.page(page, null);
        boolean next = page.hasNext();//是否有下一页
        model.addAttribute("next",next);
        boolean pre = page.hasPrevious();//是否有上一页
        model.addAttribute("previous",pre);
        List<TeacherInfo> l = page.getRecords();//获得的记录
        model.addAttribute("teachers",l);
        long now = page.getCurrent();//现在在哪一页
        model.addAttribute("now", now);
//        long last = page.getPages();//一共有多少页
//        model.addAttribute("last", last);
        return "admin/admin_teacher";
    }

    @PostMapping("/save")
    public String save(TeacherInfo teacherInfo){
        teacherInfoService.save(teacherInfo);
        return "redirect:/AssignMent/teacher/admin";
    }

    @PostMapping("/update")
    public String updatet(TeacherInfo teacherInfo){
        teacherInfoService.updateById(teacherInfo);
        return "redirect:/AssignMent/teacher/admin";
    }

    @GetMapping("deltea")
    public String deltea(Integer id){
        teacherInfoService.removeById(id);
        return "redirect:/AssignMent/teacher/admin";
    }

}
