package com.example.demo_02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "ReQuestDemo07", value = "/ReQuestDemo07")
public class ReQuestDemo07 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ReQuestDemo07....");
        request.setAttribute("msg","hello"); // 共享数据域

        request.getRequestDispatcher("/ReQuestDemo08").forward(request,response);
    }
}
