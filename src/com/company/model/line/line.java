package com.company.model.line;

import com.company.model.entity.mineral;

import java.awt.*;

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
     * line constructor
     *
     * @param _x x
     * @param _y y
     */
    public line(int _x, int _y) {
        this.x = _x;
        this.endx = this.x;
        this.y = _y + 100;
        this.endy = this.y + 100;
        this.length = 100.0;
        this.rad = 0;
        this.state = 0;
    }

    private void getSomething() {
        for (mineral m : this.minerals) {
            if (this.endx > m.getX() && this.endx < m.getX() + m.getWidth() && this.endy > m.getY() && this.endy < m.getY() + m.getHeight())
                System.out.println("抓到了[" + m.getClass() + "]" + m.getId() + ", 价值: " + m.getPrice());
        }
    }

    /**
     * 绘制
     *
     * @param g 画笔
     */
    public void paintSelf(Graphics g) {
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
                    length += 10;
                else
                    this.state = 2;
                break;
            case 2:
                if (length <= 100)
                    this.state = 0;
                else
                    length -= 10;
                break;
            default:
                break;
        }
        //计算末尾坐标
        this.endx = (int) (this.x + length * Math.cos(rad * Math.PI));
        this.endy = (int) (this.y + length * Math.sin(rad * Math.PI));

        g.setColor(Color.red);
        g.drawLine(this.x, this.y, this.endx, this.endy);
    }

    /**
     * 设置矿物
     *
     * @param _m mineral[]
     */
    public void setMinerals(mineral[] _m) {
        this.minerals = _m;
    }
}
