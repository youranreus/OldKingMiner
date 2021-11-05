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
                    players[0].dropTheLine();
                if(e.getButton() == 3)
                    players[1].dropTheLine();
            }
        });

        while (true) {
            repaint();
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
        for (mineral mine : this.minerals)
            mine.painSelf(g2);

        for (player p : this.players)
            p.painSelf(g2);
        g.drawImage(this.offsetCanvasImage, 0, 0, null);
    }

    /**
     * MenuController constructor.
     */
    public GUIController(GameController _game) {
        this.game = _game;
        this.players = this.game.getPlayers();
        this.minerals = this.game.getGameMap().getItems();
        this.launch();
    }

}
