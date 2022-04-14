package com.luketebo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {
    @GetMapping("/company")
    public String company(Integer id, String type){
        System.out.println("id: " + id);
        System.out.println("type: " + type);
        return "company";
    }
    @GetMapping("/info")
    public String info(Model model, Integer id, String type){
        System.out.println("id: " + id);
        System.out.println("type: " + type);
        String info = id + ", " + type;
        model.addAttribute("id", id);
        model.addAttribute("type", type);
        model.addAttribute("info",info);
        return "result";
    }

}
