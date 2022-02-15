package com.example.demo_01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDemo01", value = "/ServletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 访问ServletDemo01资源会自动跳转ServletDemo02
        System.out.println("ServletDemo01.....");
        // 1. 设置状态码为302
        response.setStatus(302);
        // 2. 设置响应头location
        response.setHeader("location","/ServletDemo02");

    }
}
