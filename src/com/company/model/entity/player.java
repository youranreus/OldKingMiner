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
     *
     */
    Image bg = Toolkit.getDefaultToolkit().getImage("assets/img/peo.png");

    /**
     * player constructor
     * 玩家高2，宽1，出生于中点(400, 150) (偏差值88，104)
     *
     * @param _name 玩家名
     * @param id    玩家id
     */
    public player(String _name, int id) {
        super(_name, 2, 1, id);
        this.balance = 0;
        this.hp = 100;
        this.setY(46);
        this.setX(312);
        this.line = new line(400, 200);
    }

    /**
     * player constructor
     * 非默认坐标构造
     *
     * @param _name 玩家名
     * @param id    玩家id
     */
    public player(String _name, int id, int _x, int _y) {
        super(_name, 2, 1, id);
        this.balance = 0;
        this.hp = 100;
        this.setY(_y - 104);
        this.setX(_x - 88);
        this.line = new line(this.x + 88, this.y + 104);
    }

    /**
     * 绘制
     *
     * @param g 画笔
     */
    public void painSelf(Graphics g) {
        g.drawImage(bg, this.x, this.y, null);
        line.paintSelf(g);
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
     * 玩家放下钩子（绳子）
     */
    public void dropTheLine() {
        if (this.line.state != 1)
            this.line.state = 1;
    }

    /**
     * 重置玩家钩子起点坐标
     */
    public void resetTheLine() {
        this.line.x = this.x + 88;
        this.line.y = this.y + 104;
    }

    /**
     * 获取玩家line
     * @return line line
     */
    public line getLine() {
        return this.line;
    }
}
