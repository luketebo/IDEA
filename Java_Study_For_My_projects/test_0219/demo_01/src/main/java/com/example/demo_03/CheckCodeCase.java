package com.example.demo_03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckCodeCase", value = "/CheckCodeCase")
public class CheckCodeCase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置编码
        request.setCharacterEncoding("utf-8");
        // 2. 获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String CheckCode = request.getParameter("CheckCode");
        // 获取session
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("CheckCode_session");
        // 先比较验证码是否相同
        if(checkCode_session.equalsIgnoreCase(CheckCode)){
            // 验证码真确
            // 比较用户名和密码，没有使用数据库，用写死的数据
            if("zhangSan".equals(username) && "123".equals(password)){

                // 重定向到success.jsp
                session.setAttribute("user",username);
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else{
                // 跳转到login.jsp
                request.setAttribute("login_error","用户名或密码错误");
                // 转发
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
            // 验证码不正确
            // 跳转到login.jsp
            request.setAttribute("cc_error","验证码错误");
            // 转发
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
