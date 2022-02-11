package com.example.demo_02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//测试request
@WebServlet("/ReQuestDemo01")
public class ReQuestDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求方式
        String method = req.getMethod();
        System.out.println(method);
        // 2. 获取虚拟目录**
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        // 3.获取servlet路径
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        // 4.获取get请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);
        // 5.获取请求URI**
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
        // 6.获取协议及版本
        String protocol = req.getProtocol();
        System.out.println(protocol);
        // 7. 获取客户机的ip地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
