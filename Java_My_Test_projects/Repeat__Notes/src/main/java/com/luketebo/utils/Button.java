package com.luketebo.utils;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String name){
        /*
        buttons[row][col].setMargin(new Insets(0,0,0,0));
        buttons[row][col].setBorder(new RoundBorder());
        buttons[row][col].setContentAreaFilled(false);
        buttons[row][col].setFocusPainted(false);
         */
//      this.setPreferredSize(new Dimension(100,70));
        this.setText(name);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setMargin(new Insets(0,0,0,0));
    }

}
