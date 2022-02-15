package com.example.demo_02;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "contextDemo01", value = "/contextDemo01")
public class contextDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过两种方式获取ServletContext对象
        //1 通过request对象
        ServletContext context_01 = request.getServletContext();
        //2.通过HttpServlet获取
        ServletContext context_02 = this.getServletContext();
        System.out.println(context_02);
        System.out.println(context_01);
        System.out.println(context_01 == context_02);
    }
}
