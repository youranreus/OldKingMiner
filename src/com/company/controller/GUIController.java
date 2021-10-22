package com.company.controller;

import com.company.utils.config;

import javax.swing.*;
import java.awt.*;

public class GUIController extends JFrame {

    Image background = Toolkit.getDefaultToolkit().getImage("assets/img/bg.png");

    /**
     * 界面初始化
     */
    void launch() {
        this.setVisible(true);
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("老金矿工@" + config.VERSION);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * 绘制
     *
     * @param g 图形
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(this.background, 0,0,null);
    }

    /**
     * MenuController constructor.
     */
    public GUIController() {
        this.launch();
    }

}
