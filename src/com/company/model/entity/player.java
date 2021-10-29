package com.company.model.entity;

import com.company.model.action.PlayerAction;

public class player extends item implements PlayerAction {

    /**
     * 玩家余额
     */
    private final int balance;

    /**
     * 玩家生命值
     */
    private final int hp;

    /**
     * 玩家钩子
     */
    private final hook phook;

    /**
     * player constructor
     * 玩家高2，宽1，出生于中点(90, 400)
     *
     * @param _name 玩家名
     * @param id    玩家id
     */
    public player(String _name, int id) {
        super(_name, 2, 1, id);
        phook = new hook(_name, this.x, this.y);
        this.balance = 0;
        this.hp = 100;
        this.setY(90);
        this.setX(400);
    }

    /**
     * 获取玩家余额
     *
     * @return int balance
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * 获取玩家血量
     *
     * @return int hp
     */
    public int getHp() {
        return this.hp;
    }

    /**
     * 玩家移动（只能在x轴移动）
     *
     * @param step 步数(左减右加)
     * @return boolean 是否移动成功
     */
    public boolean move(int step) {
        return super.move(this.getX() + step, this.getY());
    }

    /**
     * 玩家下放钩子
     *
     * @return boolean
     */
    @Override
    public boolean dropTheHook() {
        return this.phook.drop();
    }
}
