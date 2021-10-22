package com.company.controller;

import com.company.utils.config;

public class GameProcessController extends BaseController {

    /**
     * 管理的进程游戏
     */
    private GameController game;

    /**
     * 游戏进行时间
     */
    private int time;

    /**
     * 游戏是否已经结束
     */
    private boolean ended;

    /**
     * GameProcessController constructor
     *
     * @param game game
     */
    public GameProcessController(GameController game) {
        this.game = game;
        this.time = 0;
        this.ended = false;
    }

    /**
     * 游戏开始
     */
    public void start() {
        while (!this.ended) {
            System.out.println("游戏开始");
            this.displayGameInfo();

            while (!this.game.finished(this.time))
            {
                this.time++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.monitor();
            }


            if (this.game.hasPass())
                this.game = new GameController(this.game);
            else
                this.ended = true;
        }

        System.out.println("游戏已结束");
    }

    /**
     * 监测游戏内数据
     */
    private void monitor() {
        if(config.DEBUG)
        {
            System.out.println("------------------------------------------");
            System.out.println("当前游戏进度：\n关卡：" + this.game.getLevel());
            System.out.println("玩家个数："+this.game.getPlayerNum());
            System.out.println("游戏时间："+this.time + "/" +this.game.getTime());
            System.out.println("游戏得分："+this.game.getTotalScore()+"/"+this.game.getMaxScore());
        }
    }

    /**
     * 展示当前游戏信息
     */
    private void displayGameInfo() {
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
}
