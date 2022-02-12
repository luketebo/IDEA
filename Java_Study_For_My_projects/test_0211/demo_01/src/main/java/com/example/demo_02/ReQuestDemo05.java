package com.example.demo_02;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "ReQuestDemo05", value = "/ReQuestDemo05")
public class ReQuestDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 测试getReader();
        BufferedReader br = request.getReader();
//        System.out.println(br);
        String line = null;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
    }
}
