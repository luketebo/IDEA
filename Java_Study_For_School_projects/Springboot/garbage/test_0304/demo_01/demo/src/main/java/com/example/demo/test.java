package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

@RestController
@RequestMapping("/books")
public class test {
    @RequestMapping()
    public String getSpring(){
        System.out.println("spring test .....");
        return "Spring test.....";
    }
}
