package com.example.demo_02;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "contextDemo02", value = "/contextDemo02")
public class contextDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 测试MIME类型
        String filename = "a.jpg";
        ServletContext context = this.getServletContext();
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);
    }
}
