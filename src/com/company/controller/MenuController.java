package com.company.controller;

import com.company.utils.config;

import javax.swing.*;

public class MenuController extends JFrame {

    /**
     * 界面初始化
     */
    void launch() {
        this.setVisible(true);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("老金矿工@" + config.VERSION);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * MenuController constructor.
     */
    public MenuController() {
        this.launch();
    }

}
