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
    private final map gameMap;

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
    public GameController(int level, int time, int playerNum, int gameMode, int maxScore) {
        this.level = level;
        this.time = time;
        this.playerNum = playerNum;
        this.gameMode = gameMode;
        this.maxScore = maxScore;
        this.customerGame = true;
        this.gameMap = new map(this.level);
        this.init();
    }

    /**
     * GameController default constructor
     * 生成普通模式lv0关卡
     *
     * @param playerNum 玩家人数
     */
    public GameController(int playerNum) {
        this.level = 0;
        this.gameMode = 1;
        this.playerNum = playerNum;
        this.gameMap = new map(0);
        this.init();
    }

    /**
     * 从上层关卡复制得到新关卡
     *
     * @param upper 上层关卡
     */
    public GameController(GameController upper) {
        this.players = upper.players;
        this.level = upper.level == 100 ? 100 : upper.level + 1;
        this.gameMode = upper.gameMode;
        this.time = upper.level == 100 ? 80 : upper.time - 1;
        this.customerGame = upper.customerGame;
        this.playerNum = upper.playerNum;
        this.maxScore = upper.maxScore + 120;
        this.gameMap = new map(upper.level + 1);
        this.gameMap.init();
    }

    /**
     * 关卡初始化
     * 初始化规则：
     * 时间为 (180 - level)s 直到第100关 80s
     * maxScore 为从 (500+level*120) 分
     */
    private void init() {
        this.gameMap.init();
        this.players = new player[this.playerNum];
        for (int i = 0; i < playerNum; i++)
        {
            this.players[i] = new player("玩家" + i, 1000 + i);
            this.players[i].setLineMineral(this.gameMap.getItems());
        }


        //两人时就自动移开
        if(this.playerNum == 2) {
            this.players[0].setX(212);
            this.players[1].setX(412);
            this.players[0].resetTheLine();
            this.players[1].resetTheLine();
        }

        if (this.customerGame)
            return;
        this.time = this.gameMode == 2 ? 999999 : 180 - this.level;
        this.maxScore = 500 + level * 120;
    }

    /**
     * 游戏是否结束
     *
     * @param t 已经进行时间
     * @return 是否结束
     */
    public boolean finished(int t) {
        if (this.gameMode == 1 || this.gameMode == 3)
            return this.time <= t;
        return this.gameMode == 4 && this.isSomePlayerWin();
    }

    /**
     * 是否已经有玩家取胜
     *
     * @return boolean
     */
    private boolean isSomePlayerWin() {
        for (player _player : this.players) {
            if (_player.getBalance() >= this.maxScore)
                return true;
        }
        return true;
    }

    /**
     * 判断是否通关
     *
     * @return boolean
     */
    public boolean hasPass() {
        return this.getTotalScore() >= this.maxScore;
    }

    /**
     * 获取关卡等级
     *
     * @return int level
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * 获取关卡总时间
     *
     * @return int time
     */
    public int getTime() {
        return this.time;
    }

    /**
     * 获取当前关卡模式
     *
     * @return int mode
     */
    public int getGameMode() {
        return gameMode;
    }

    /**
     * 获取当前关卡人数
     *
     * @return int num
     */
    public int getPlayerNum() {
        return playerNum;
    }

    /**
     * 获取当前关卡最及格/决胜分
     *
     * @return int score
     */
    public int getMaxScore() {
        return maxScore;
    }

    /**
     * 获取当前所有玩家总得分
     *
     * @return int score
     */
    public int getTotalScore() {
        int total = 0;
        for (player _player : this.players)
            total += _player.getBalance();

        return total;
    }

    /**
     * 获取地图信息
     *
     * @return map 游戏地图
     */
    public map getGameMap() {
        return this.gameMap;
    }

    /**
     * 获取玩家信息
     *
     * @return player[] 玩家集合
     */
    public player[] getPlayers() {
        return players;
    }
}
