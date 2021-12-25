package com.company.controller;

import com.company.model.map.background;
import com.company.utils.config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController extends JFrame {

    /**
     * 背景图片
     */
    background bg;

    /**
     * 双缓存画布
     */
    Image offsetCanvasImage;

    /**
     * 是否进入游戏
     */
    boolean notEntered;

    /**
     * 按钮
     */
    MenuItem[] btn;

    /**
     * constructor.
     */
    public MenuController() {
        this.setVisible(true);
        this.setSize(800, 420);
        this.setTitle("老金矿工");
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        bg = new background();
        this.notEntered = true;
        btn = new MenuItem[3];
        btn[0] = new MenuItem("Solo");
        btn[1] = new MenuItem("Host");
        btn[2] = new MenuItem("Remote");

        btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solo();
            }
        });

        btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                host();
            }
        });

        btn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remote();
            }
        });

        Menu m = new Menu("start");
        MenuBar mb = new MenuBar();
        m.add(btn[0]);
        m.add(btn[1]);
        m.add(btn[2]);
        mb.add(m);
        this.setMenuBar(mb);
        this.play();
    }

    /**
     * 单人游戏
     */
    private void solo() {
        config.online = 0;
        System.out.println("选择了单人模式");
        config.players = 1;
        this.enter();
    }

    /**
     * 主机模式
     */
    private void host() {
        config.online = 1;
        System.out.println("选择了主机模式");
        this.enter();
    }

    /**
     * 远程模式
     */
    private void remote() {
        config.online = 2;
        System.out.println("选择了远程模式");
        this.enter();
    }

    /**
     * 进程控制
     */
    public void play() {
        while (this.notEntered) {
            this.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 进入游戏
     */
    public void enter() {
        this.setVisible(false);
        this.notEntered = false;
    }

    /**
     * 绘制文字
     *
     * @param toDraw 要绘制的字符串
     * @param g      画笔
     */
    public void drawString(String toDraw, Graphics g, int x, int y, int size, Color color) {
        g.setColor(color);
        g.setFont(new Font("jetbrains mono", Font.ITALIC, size));
        g.drawString(toDraw, x, y);
    }

    @Override
    public void paint(Graphics g) {
        this.offsetCanvasImage = this.createImage(800, 420);
        Graphics g2 = this.offsetCanvasImage.getGraphics();
        bg.painSelf(g2);
        this.drawString("version: " + config.VERSION, g2, 10, 70, 18, Color.WHITE);
        this.drawString("By: ZZF & DRE", g2, 645, 405, 18, Color.WHITE);
        this.drawString("OldKing Miner(s)", g2, 240, 220, 40, Color.WHITE);
        g.drawImage(this.offsetCanvasImage, 0, 0, null);
    }
}
