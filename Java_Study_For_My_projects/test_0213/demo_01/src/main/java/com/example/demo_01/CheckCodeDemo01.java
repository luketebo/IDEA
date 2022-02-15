package com.example.demo_01;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "CheckCodeDemo01", value = "/CheckCodeDemo01")
public class CheckCodeDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 制作验证码
        int width = 100;
        int height = 50;

        // 1. 创建对象，在内存中图片(验证码图片对象)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);

        // 2.美化图片
        // 2.1 填充背景色
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,width,height);

        //2.2 化边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width - 1, height - 1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrst1234567890";

        // 随机字符
        Random ran = new Random();

        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            g.drawString(ch+"",width/5*i,height/2);
        }

        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        // 3.输出图片

        ImageIO.write(image,"jpg",response.getOutputStream());


    }
}
