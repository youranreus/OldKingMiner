package com.company.model.entity;

import com.company.model.action.PlayerAction;
import com.company.model.line.line;

import java.awt.*;
import java.net.MalformedURLException;

public class player extends item implements PlayerAction {

    /**
     * 玩家余额
     */
    private int balance;

    /**
     * 玩家生命值
     */
    private final int hp;

    /**
     * 玩家红线
     */
    public final line line;

    /**
     *
     */
    Image bg = Toolkit.getDefaultToolkit().getImage("assets/img/peo.png");

    /**
     * player constructor
     * 玩家高2，宽1，出生于中点(400, 150) (偏差值54，64)
     *
     * @param _name 玩家名
     * @param id    玩家id
     */
    public player(String _name, int id) throws MalformedURLException {
        super(_name, 2, 1, id);
        this.balance = 0;
        this.hp = 100;
        this.setY(86);
        this.setX(346);
        this.line = new line(400, 100);
        this.line.setOwner(this);
    }

    /**
     * player constructor
     * 非默认坐标构造
     *
     * @param _name 玩家名
     * @param id    玩家id
     */
    public player(String _name, int id, int _x, int _y) throws MalformedURLException {
        super(_name, 2, 1, id);
        this.balance = 0;
        this.hp = 100;
        this.setY(_y - 64);
        this.setX(_x - 54);
        this.line = new line(this.x + 54, this.y + 64);
        this.line.setOwner(this);
    }

    /**
     * 绘制
     *
     * @param g 画笔
     */
    public void painSelf(Graphics g) throws MalformedURLException {
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
        this.line.x = this.x + 54;
        this.line.y = this.y + 64;
    }

    /**
     * 获取玩家line
     * @return line line
     */
    public line getLine() {
        return this.line;
    }

    /**
     * 设置绳子的矿物检测
     * @param _m mineral
     */
    public void setLineMineral(mineral[] _m) {
        this.line.setMinerals(_m);
    }

    /**
     * 设置余额
     *
     * @param value int
     */
    public void setBalance(int value) {
        this.balance = value;
    }
}
