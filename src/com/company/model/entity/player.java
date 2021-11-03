package com.company.model.entity;

import com.company.model.action.PlayerAction;
import com.company.model.line.line;

import java.awt.*;

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
     * 玩家红线
     */
    private final line line;

    /**
     * player constructor
     * 玩家高2，宽1，出生于中点(90, 400)
     *
     * @param _name 玩家名
     * @param id    玩家id
     */
    public player(String _name, int id) {
        super(_name, 2, 1, id);
        this.balance = 0;
        this.hp = 100;
        this.setY(90);
        this.setX(400);
        this.line = new line(this.getX(), this.getY());
    }

    /**
     * 绘制
     * @param g 画笔
     */
    public void painSelf(Graphics g) {

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

}
