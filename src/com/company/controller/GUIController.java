package com.company.controller;

import com.company.model.entity.mineral;
import com.company.model.entity.player;
import com.company.model.map.background;

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
     * 玩家
     */
    player[] players;

    /**
     * 矿物
     */
    mineral[] minerals;

    /**
     * 绘图线程
     */
    GUIThread thread;

    /**
     * 界面初始化
     */
    void launch() {
        this.setVisible(true);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        bg = new background();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == 1)
                    if (players[0].getLine().state == 0)
                        players[0].dropTheLine();
                if (e.getButton() == 3)
                    if (players[1].getLine().state == 0)
                        players[1].dropTheLine();
            }
        });

        this.thread.start();
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
        for (mineral mine : this.minerals)
            mine.painSelf(g2);

        for (player p : this.players)
            p.painSelf(g2);
        this.drawString("Score: " + this.game.getTotalScore(), g2, 30, 70, 30, Color.WHITE);
        this.drawString("Level: " + this.game.getLevel(), g2, 630, 70, 30, Color.WHITE);
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
     * MenuController constructor.
     */
    public GUIController(GameController _game) {
        this.game = _game;
        this.players = this.game.getPlayers();
        this.minerals = this.game.getGameMap().getItems();
        this.thread = new GUIThread();
        this.thread.setController(this);
        this.launch();
    }

}

class GUIThread extends Thread {

    GUIController controller;

    public void setController(GUIController c) {
        controller = c;
    }

    public void run() {
        while (true) {
            controller.repaint();
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
