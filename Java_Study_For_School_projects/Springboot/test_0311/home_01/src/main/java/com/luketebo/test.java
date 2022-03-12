package com.luketebo;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 作业1： 使用java编写读取和写入多行文本的程序
 * 静态成员属于类,不需要生成对象就存在了.而非静态需要生成对象才产生.所以静态成员不能直接访问非静态.
 */
public class test {
    public static void File_read(File file){

        System.out.println("读取文件内容\n");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            char[] ch = new char[1024];
            fileReader.read(ch);
            for (char c:  ch) {
                System.out.print(c);
            }
            System.out.println();

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                fileReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void File_write(File file) {
        String input_f = null;
        System.out.println("输入文件内容：\n");
        Scanner sc = new Scanner(System.in);
        input_f = sc.nextLine();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(input_f);
            fileWriter.flush();

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try{

                fileWriter.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        String dir = "D://ac.txt";
        File file = new File(dir);
        Scanner sc = new Scanner(System.in);
        String chose;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            System.out.println("--------------文件操作-------------------\n");
            System.out.println("请输入操作:1.读取文件 2. 写入文件");
            chose = sc.nextLine();
            if("1".equals(chose)){
                File_read(file);
            }else if("2".equals(chose)){
                File_write(file);
            }else{
                System.out.println("操作未知\n");
                System.out.println("Fuck you !!!!");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
