package com.luketebo.utils;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String name){


        this.setText(name);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setMargin(new Insets(0,0,0,0));
        this.setFont(new Font("Console",Font.BOLD,24));
    }
    public Button(String name,Icon demo){
        this.setText(name);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setMargin(new Insets(0,0,0,0));
        this.setFont(new Font("Console",Font.BOLD,24));
    }
    // 实现icon方法
    Icon demo = new Icon() {
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {

        }

        @Override
        public int getIconWidth() {
            return 0;
        }

        @Override
        public int getIconHeight() {
            return 0;
        }
    };


}
