package com.luketebo.function;

import java.util.Scanner;

public class Function {
    public static void main(String[] args) {
        String note_create_date;
        String note_edit_date;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入笔记创建时间：");
        note_create_date = in.nextLine();
        System.out.println("请输入笔记修改时间: ");
        note_edit_date = in.nextLine();
        System.out.println("笔记创建时间： " + note_create_date);
        System.out.println("笔记修改时间： " + note_edit_date);
        // 变化时间（复习时间） 1 2 4 7 15 30 60 ......


    }
}
