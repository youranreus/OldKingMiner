package com.company.controller;

import com.company.model.map.map;
import com.company.model.entity.player;

public class GameController extends BaseController {

    /**
     * 关卡等级
     * 0 ~ 100
     */
    private final int level;

    /**
     * 关卡时间(s)
     * 60 ~ 180
     */
    private int time;

    /**
     * 玩家数量
     * 1 ~ 2
     */
    private final int playerNum;

    /**
     * 关卡模式
     * 1 -> 普通模式
     * 2 -> 无尽模式
     * 3 -> PK模式（时间限）
     * 4 -> PK模式（分数限）
     */
    private final int gameMode;

    /**
     * PK模式最高积分 / 普通模式及格分
     */
    private int maxScore;

    /**
     * 游戏地图
     */
    private map gameMap;

    /**
     * 游戏玩家
     */
    private player[] players;

    /**
     * 是否为自定义关卡
     */
    private boolean customerGame;

    /**
     * GameController customer constructor
     * 生成自定义关卡
     *
     * @param level     关卡等级
     * @param time      关卡时间
     * @param playerNum 玩家人数
     * @param gameMode  关卡模式
     * @param maxScore  最高分数
     */
    GameController(int level, int time, int playerNum, int gameMode, int maxScore) {
        this.level = level;
        this.time = time;
        this.playerNum = playerNum;
        this.gameMode = gameMode;
        this.maxScore = maxScore;
        this.customerGame = true;
        this.init();
    }

    /**
     * GameController default constructor
     * 生成普通模式lv0关卡
     *
     * @param playerNum 玩家人数
     */
    GameController(int playerNum) {
        this.level = 0;
        this.gameMode = 1;
        this.playerNum = playerNum;
        this.init();
    }

    /**
     * 从上层关卡复制得到新关卡
     *
     * @param upper 上层关卡
     */
    GameController(GameController upper) {
        this.players = upper.players;
        this.level = upper.level == 100 ? 100 : upper.level + 1;
        this.gameMode = upper.gameMode;
        this.time = upper.level == 100 ? 80 : upper.time - 1;
        this.customerGame = upper.customerGame;
        this.playerNum = upper.playerNum;
        this.maxScore = upper.maxScore + 120;
        this.gameMap = upper.gameMap;
    }

    /**
     * 关卡初始化
     * 初始化规则：
     * 时间为 (180 - level)s 直到第100关 80s
     * maxScore 为从 (500+level*120) 分
     */
    private void init() {
        for (int i = 0; i < playerNum; i++)
            this.players[i] = new player("玩家" + i, 1000 + i);

        if (this.customerGame)
            return;
        this.time = 180 - this.level;
        this.maxScore = 500 + level * 120;
    }


}
