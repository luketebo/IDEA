package com.example.demo_02;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "downLoadDemo01", value = "/downLoadDemo01")
public class downLoadDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数，文件名
        String filename = request.getParameter("filename");
        //2.将字节输入流加载文件进内存
        //2.1找到下载服务器地址
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/FILE/" + filename);
        //2.2使用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        //3.设置repose响应头
        // 获取文件mime类型
        String mimeType = context.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        // 设置打开方式
        response.setHeader("content-disposition","attachment;filename="+filename);

        //4.将输入流的数据写入到输入流
        ServletOutputStream outputStream = response.getOutputStream();
        //定义缓冲区
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fis.read(buff)) != -1){
            outputStream.write(buff,0,len);
        }
        fis.close();;
    }
}
