package com.luketebo.frame;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

// 测试button 设置图标的方法
public class MainFrame extends JFrame {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.setSize(600,600);
    }
    public MainFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setTitle("test");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        URL url = getClass().getResource("/icon/add.png");
//        assert url != null;
//        System.out.println(url);
        final Icon icon = new ImageIcon("../icon/add.png");

        final JButton jButton = new JButton("测试");
        jButton.setIcon(icon);

        jButton.setPreferredSize(new Dimension(200,200));
        JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(500,500));
        jPanel.setBorder(BorderFactory.createTitledBorder("jPanel"));
        jPanel.add(jButton);
        getContentPane().add(jPanel);

    }

}
