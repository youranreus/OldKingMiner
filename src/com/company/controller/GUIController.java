package com.company.controller;

import com.company.model.map.background;
import com.company.utils.config;

import javax.swing.*;
import java.awt.*;
import com.company.model.line.line;

public class GUIController extends JFrame {

    /**
     * 背景图片
     */
    background bg;

    line testline;

    /**
     * 界面初始化
     */
    void launch() {
        this.setVisible(true);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setTitle("老金矿工@" + config.VERSION);
        testline = new line(400, 90);
        bg = new background();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * 绘制
     *
     * @param g 图形
     */
    @Override
    public void paint(Graphics g) {
        bg.painSelf(g);
        testline.paintSelf(g);
    }

    /**
     * MenuController constructor.
     */
    public GUIController() {
        this.launch();
    }

}
