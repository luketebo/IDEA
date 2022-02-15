package com.example.demo_01;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ServletDemo04", value = "/ServletDemo04")
public class ServletDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 测试两个方法
        // 1. 获取字节流
        ServletOutputStream servletOutputStream = response.getOutputStream();
        // 2. 输出数据
        servletOutputStream.write(" hello 你好 response".getBytes());

        /*
          我懂了我设置的问题，getBytes()为gbk，我开头设置的utf-8两者的编码集冲突，
          我如果要使用uft-8，getBytes()也要使用utf-8
         */
    }
}
