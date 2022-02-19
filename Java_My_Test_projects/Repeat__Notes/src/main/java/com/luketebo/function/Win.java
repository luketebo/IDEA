package com.luketebo.function;

import com.luketebo.utils.Button;

import javax.swing.*;
import java.awt.*;

public class Win extends JFrame {
    private final String content = "随手记可以用来快速记录一些：\n" +
            "代码片段、常用的SQL、常用的接口、常用的数据、暂存一些临时log等\n" +
            "\n" +
            "点击加号按钮，开始创建一条新的笔记";
    // 组件
    private final List list = new List();
    private final JTextArea jTextarea = new JTextArea(content,10,88);

    // 图标
    private final Icon edit = new ImageIcon("icon/edit.svg");
    private final Icon note_icon = new ImageIcon("icon/copy.png");
    private final Icon day = new ImageIcon("icon/schedule.svg");

    // 面板
    private final JPanel totalPanel = new JPanel();
    // 暂不使用
//    private final JPanel topBar = new JPanel();

    private final JPanel changeBar = new JPanel();
    private final JPanel centerBar = new JPanel();
    private final JPanel leftOperateBar = new JPanel();
    private final JScrollPane leftOperateBar_jsp = new JScrollPane(list);
    private final JPanel rightOperateBar = new JPanel();
    private final JPanel rightOperateBar_top = new JPanel();
    private final JPanel rightOperateBar_center = new JPanel();
    private final JScrollPane rightOperateBat_center_center = new JScrollPane(jTextarea);
    private final JPanel rightOperateBar_center_left = new JPanel();

    // 按钮
    private final Button writeFree = new Button("随手记",edit); // 随手记
    private final Button note = new Button("笔记",note_icon); // 笔记
    private final Button dayLine = new Button("日程",day); // 日程
    private final Button demo_01 = new Button("梦厅"); // 日程
    private final Button demo_02 = new Button("课表"); // 日程
    private final Button demo_03 = new Button("宇树"); // 日程
    private final Button demo_04 = new Button("日记"); // 日程
    private final Button demo_05 = new Button("问题"); // 日程
    private final Button demo_06 = new Button("案例"); // 日程
    private final Button demo_07 = new Button("案例"); // 日程



    public Win() {
    }

    public void init(){


        setTitle("MeTools");



        changeBar.setPreferredSize(new Dimension(1520,70));

        changeBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridLayout gridLayout = new GridLayout(1,10);
        gridLayout.setVgap(15);
        changeBar.setLayout(gridLayout);

        changeBar.add(writeFree);
        changeBar.add(note);
        changeBar.add(dayLine);
        changeBar.add(demo_01);
        changeBar.add(demo_02);
        changeBar.add(demo_03);
        changeBar.add(demo_04);
        changeBar.add(demo_05);
        changeBar.add(demo_06);
        changeBar.add(demo_07);



        centerBar.setPreferredSize(new Dimension(1520,760));
        centerBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerBar.setLayout(new BorderLayout());



        leftOperateBar_jsp.setPreferredSize(new Dimension(200,750));
        leftOperateBar.add(leftOperateBar_jsp);





        rightOperateBar_top.setPreferredSize(new Dimension(1300,70));
        rightOperateBar_top.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        rightOperateBar_center.setPreferredSize(new Dimension(1300,760));
        rightOperateBar_center.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // 添加文本域
        jTextarea.setLineWrap(true); // 设置自动换行
        jTextarea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jTextarea.setFont(new Font("Console",Font.BOLD,24));


        rightOperateBat_center_center.setPreferredSize(new Dimension(1220,670));

        rightOperateBar_center_left.setPreferredSize(new Dimension(50,670));
        rightOperateBar_center_left.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        rightOperateBar_center.add(rightOperateBar_center_left,BorderLayout.WEST);
        rightOperateBar_center.add(rightOperateBat_center_center,BorderLayout.CENTER);

        rightOperateBar.add(rightOperateBar_top,BorderLayout.NORTH);
        rightOperateBar.add(rightOperateBar_center,BorderLayout.CENTER);

        centerBar.add(leftOperateBar,BorderLayout.WEST);
        centerBar.add(rightOperateBar,BorderLayout.CENTER);

        totalPanel.add(changeBar,BorderLayout.NORTH);
        totalPanel.add(centerBar,BorderLayout.CENTER);

        getContentPane().add(totalPanel);

    }

}
