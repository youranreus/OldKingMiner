package com.company.controller;

import com.company.model.entity.player;
import com.company.model.map.background;
import com.company.utils.config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIController extends JFrame {

    /**
     * 背景图片
     */
    background bg;

    player testPlayer;

    /**
     * 界面初始化
     */
    void launch() {
        this.setVisible(true);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setTitle("老金矿工@" + config.VERSION);
        testPlayer = new player("player1", 1001);
        bg = new background();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton() == 1)
                    testPlayer.dropTheLine();
            }
        });

        while (true) {
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 绘制
     *
     * @param g 图形
     */
    @Override
    public void paint(Graphics g) {
        bg.painSelf(g);
        testPlayer.painSelf(g);
    }

    /**
     * MenuController constructor.
     */
    public GUIController() {
        this.launch();
    }

}
