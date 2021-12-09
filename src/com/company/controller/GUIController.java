package com.company.controller;

import com.company.model.entity.mineral;
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

    /**
     * 双缓存画布
     */
    Image offsetCanvasImage;

    /**
     * 游戏
     */
    GameController game;

    /**
     * 游戏进程控制器
     */
    GameProcessController GP;

    /**
     * 玩家
     */
    player[] players;

    /**
     * 矿物
     */
    mineral[] minerals;

    /**
     *
     */
    public boolean running = false;

    /**
     * 联机管理器
     */
    public NetController net = new NetController(this);

    /**
     * 界面初始化
     */
    void launch() {
        this.setVisible(true);
        this.setSize(800, 800);
        this.setTitle("老金矿工     "+ ((config.online == 0) ? "[本地模式]" : "[联机模式-" + ((config.online==1)?"主机]":"从机]")) +"v"+ config.VERSION);
        this.setLocationRelativeTo(null);
        bg = new background();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("监听点击事件");
                if (e.getButton() == 1){
                    if(config.online == 1) {
                        if (players[0].getLine().state == 0) {
                            System.out.println("主机自己点击");
                            players[0].dropTheLine();
                            net.sendClick();
                        }
                    }
                    else if(config.online == 2) {
                        if (players[1].getLine().state == 0) {
                            System.out.println("从机自己点击");
                            players[1].dropTheLine();
                            net.sendClick();
                        }
                    }
                    else {
                        if (players[0].getLine().state == 0) {
                            players[0].dropTheLine();
                        }
                    }
                }

                if (e.getButton() == 3 && players[1].getLine().state == 0){
                    players[1].dropTheLine();
                }
            }
        });
        this.running = true;
        while (true) {
            if(this.running)
                this.repaint();
            try {
                Thread.sleep(10);
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
        //双缓存，基准画布
        this.offsetCanvasImage = this.createImage(800, 800);
        Graphics g2 = this.offsetCanvasImage.getGraphics();

        bg.painSelf(g2);
        if(this.minerals == null)
            this.minerals = this.game.getGameMap().getItems();
        for (mineral mine : this.minerals)
            mine.painSelf(g2);

        for (player p : this.players)
            p.painSelf(g2);
        this.drawString("Score: " + this.game.getTotalScore() + "/" + this.game.getMaxScore(), g2, 30, 70, 20, Color.WHITE);
        this.drawString("Level: " + this.game.getLevel(), g2, 680, 70, 20, Color.WHITE);
        this.drawString(this.GP.getTime()+"/"+this.game.getTime(), g2, 380, 70, 20, Color.WHITE);
        g.drawImage(this.offsetCanvasImage, 0, 0, null);
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

    /**
     * 清除矿物，进入下一关
     */
    public void nextLevel() {
        this.running = false;
        dispose();
    }

    /**
     * 另一名玩家点击
     */
    public void anotherClick() {
        if(config.online == 2) {
            if (players[0].getLine().state == 0) {
                players[0].dropTheLine();
            }
        }
        else if(config.online == 1) {
            if (players[1].getLine().state == 0) {
                players[1].dropTheLine();
            }
        }
    }

    /**
     * MenuController constructor.
     */
    public GUIController(GameProcessController _game) {
        this.game = _game.getGame();
        this.GP = _game;
        this.players = this.game.getPlayers();
        this.minerals = this.game.getGameMap().getItems();
        this.launch();
    }

}