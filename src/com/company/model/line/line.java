package com.company.model.line;

import com.company.model.entity.hook;
import com.company.model.entity.mineral;
import com.company.model.entity.player;
import com.company.utils.soundThread;

import java.awt.*;
import java.net.MalformedURLException;

public class line {

    /**
     * 起点坐标x
     */
    public int x;

    /**
     * 起点坐标y
     */
    public int y;


    /**
     * 终点坐标x
     */
    public int endx;


    /**
     * 终点坐标y
     */
    public int endy;

    /**
     * 线长
     */
    public double length;

    /**
     * 角度
     */
    public double rad;

    /**
     * 状态
     * 0: 摆动
     * 1: 放下
     * 2: 回收
     * 3: 抓取返回
     */
    public int state;

    /**
     * 方向修正
     */
    public int direction;

    /**
     * 矿物集合，用于抓取判定
     */
    private mineral[] minerals;

    /**
     * 已经抓取的矿物的数组索引
     */
    private int mineralCaughtIndex;

    /**
     * 抓取速度
     * 空抓: 10
     * 金矿: 7
     * 岩石: 3
     * 钻石: 8
     */
    private int speed;

    /**
     * 钩子主人
     */
    private player owner;

    /**
     * 钩爪
     */
    private hook hook;

    /**
     * line constructor
     *
     * @param _x x
     * @param _y y
     */
    public line(int _x, int _y) throws MalformedURLException {
        this.x = _x;
        this.endx = this.x;
        this.y = _y + 100;
        this.endy = this.y + 100;
        this.length = 100.0;
        this.rad = 0;
        this.state = 0;
        this.mineralCaughtIndex = -1;
        this.speed = 20;
        this.hook = new hook("player", this.endx, this.endy);
    }

    private void getSomething() throws MalformedURLException {
        int index = 0;
        for (mineral m : this.minerals) {
            if (!m.isCaught() && this.endx > m.getX() && this.endx < m.getX() + m.getWidth() && this.endy > m.getY() && this.endy < m.getY() + m.getHeight()) {
                System.out.println("抓到了[" + m.getName() + "]" + m.getId() + ", 价值: " + m.getPrice());
                this.state = 3;
                this.mineralCaughtIndex = index;
                switch (m.getName()) {
                    case "金矿" -> {
                        this.speed = 7;
                    }
                    case "钻石" -> {
                        this.speed = 5;
                    }
                    case "岩石" -> {
                        this.speed = 3;
                    }
                    default -> {
                    }
                }
            }
            index++;
        }
    }

    /**
     * 绘制
     *
     * @param g 画笔
     */
    public void paintSelf(Graphics g) throws MalformedURLException {
        getSomething();
        switch (this.state) {
            case 0:
                if (rad < 0.1)
                    direction = 1;
                else if (rad > 0.9)
                    direction = -1;
                rad = rad + 0.005 * direction;
                break;
            case 1:
                if (length <= 1000)
                    length += this.speed;
                else
                    this.state = 2;
                break;
            case 2:
                if (length <= 100)
                    this.state = 0;
                else
                    length -= this.speed;
                break;
            case 3:
                if (length <= 100) {
                    this.minerals[this.mineralCaughtIndex].setX(-150);
                    this.minerals[this.mineralCaughtIndex].setY(-150);
                    this.state = 0;
                    this.speed = 20;
                    this.owner.setBalance(this.owner.getBalance() + this.minerals[this.mineralCaughtIndex].getPrice());
                    this.minerals[this.mineralCaughtIndex].getCaught();
                } else {
                    length -= this.speed;
                    this.minerals[this.mineralCaughtIndex].setX(this.endx - this.minerals[this.mineralCaughtIndex].getWidth() / 2);
                    this.minerals[this.mineralCaughtIndex].setY(this.endy);
                }
                break;
            default:
                break;
        }
        //计算末尾坐标
        this.endx = (int) (this.x + length * Math.cos(rad * Math.PI));
        this.endy = (int) (this.y + length * Math.sin(rad * Math.PI));

        g.setColor(Color.red);
        g.drawLine(this.x - 1, this.y, this.endx - 1, this.endy);
        g.drawLine(this.x, this.y, this.endx, this.endy);
        g.drawLine(this.x + 1, this.y, this.endx + 1, this.endy);
        this.hook.setXY(this.endx, this.endy);
        this.hook.painSelf(g);
    }

    /**
     * 设置矿物
     *
     * @param _m mineral[]
     */
    public void setMinerals(mineral[] _m) {
        this.minerals = _m;
    }

    /**
     * 设置主人
     *
     * @param _owner player
     */
    public void setOwner(player _owner) {
        this.owner  = _owner;
    }
}
