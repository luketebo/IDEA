package com.example.demo_02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "ReQuestDemo06", value = "/ReQuestDemo06")
public class ReQuestDemo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 测试getParameter();
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println(username);
        // 测试String[] getParameter(String name)
        String[] usernames = request.getParameterValues("hobby");
//        for (String name: usernames) {
//            System.out.println(name);
//        }
        // 测试Enumeration<String> getParameterNames();
        Enumeration<String> parameterNames = request.getParameterNames();
//        while(parameterNames.hasMoreElements()){
//            String name = parameterNames.nextElement();
//            System.out.println(name);
//            String value = request.getParameter(name);
//            System.out.println(value);
//            System.out.println("---------------");
//        }
        // 测试Map<String String[]) getParameterMap();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
//        for (String name : keySet) {
//            // 根据name获取键获取值
//            String[] values = parameterMap.get(name);
//            for (String value : values) {
//                System.out.println(value);
//            }
//            System.out.println("---------------");
//        }
    }
}
