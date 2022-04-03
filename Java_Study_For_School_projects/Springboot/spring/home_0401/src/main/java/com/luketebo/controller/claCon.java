package com.luketebo.controller;

import com.luketebo.dao.Cla;
import com.luketebo.doamin.Classes;
import com.luketebo.service.claSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class claCon {
    @Autowired
    private claSer claSer;

    @GetMapping("classes")
    public String getCla(Model model){
        List<Classes> data = claSer.findAll();
        model.addAttribute("classes",data);
        return "classes";
    }
}
