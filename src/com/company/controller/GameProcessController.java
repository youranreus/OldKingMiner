package com.company.controller;

import com.company.utils.config;

import java.net.MalformedURLException;

public class GameProcessController extends BaseController {

    /**
     * 管理的进程游戏
     */
    public GameController game;

    /**
     * 管理的窗体控制器
     */
    public GUIController gui;

    /**
     * 游戏进行时间
     */
    public int time;

    /**
     * 游戏是否已经结束
     */
    private boolean ended;

    /**
     * 控制器线程
     */
    private GPThread thread;

    /**
     * GameProcessController constructor
     *
     * @param game game
     */
    public GameProcessController(GameController game) {
        this.game = game;
        this.time = 0;
        this.ended = false;
        this.start();
        this.gui = new GUIController(this);
    }

    /**
     * 游戏开始
     */
    public void start() {
        this.thread = new GPThread();
        this.thread.setController(this);
        this.thread.start();
    }

    /**
     * 下一关
     */
    public void nextLevel() throws MalformedURLException {
        if (config.DEBUG)
            System.out.println("已过关");
        this.game = new GameController(this.game);
        if (config.DEBUG)
            System.out.println("关卡初始化完成");
        this.time = 0;

        this.gui = new GUIController(this);
        this.gui.nextLevel();
    }

    /**
     * 监测游戏内数据
     */
    public void monitor() {
        if (config.DEBUG) {
            System.out.println("------------------------------------------");
            System.out.println("当前游戏进度：\n关卡：" + this.game.getLevel());
            System.out.println("玩家个数：" + this.game.getPlayerNum());
            System.out.println("游戏时间：" + this.time + "/" + this.game.getTime());
            System.out.println("游戏得分：" + this.game.getTotalScore() + "/" + this.game.getMaxScore());
            System.out.println("联机模式：" + config.online);
        }
    }

    /**
     * 展示当前游戏信息
     */
    public void displayGameInfo() {
        System.out.println("当前游戏关卡信息：");
        System.out.println("level => " + this.game.getLevel());
        System.out.println("players => " + this.game.getPlayerNum());
        System.out.print("mode => ");
        switch (this.game.getGameMode()) {
            case 1 -> System.out.println("普通模式");
            case 2 -> System.out.println("无尽模式");
            default -> System.out.println("PK模式");
        }
    }

    /**
     * 获取游戏
     *
     * @return game
     */
    public GameController getGame() {
        return this.game;
    }

    /**
     * 获取游戏已经运行时间
     *
     * @return time
     */
    public int getTime() {
        return this.time;
    }

    /**
     * 是否结束
     *
     * @return boolean
     */
    public boolean isEnded() {
        return ended;
    }

    /**
     * 结束
     *
     * @param ended false
     */
    public void setEnded(boolean ended) {
        this.ended = ended;
    }
}

class GPThread extends Thread {

    GameProcessController controller;

    public void setController(GameProcessController c) {
        controller = c;
    }

    public void run() {
        while((controller.gui == null || !controller.gui.net.connected) && config.online != 0) {

        }
        while (!controller.isEnded()) {
            System.out.println("游戏开始");
            controller.displayGameInfo();

            while (!controller.game.finished(controller.time)) {
                controller.time++;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                controller.monitor();
            }

            if (controller.game.hasPass()) {
                try {
                    controller.nextLevel();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            else
                controller.setEnded(true);
        }

        System.out.println("游戏已结束");
    }
}
