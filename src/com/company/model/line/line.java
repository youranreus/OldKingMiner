package com.company.model.line;

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
     * 方向修正
     */
    public int direction;

    public line(int _x, int _y) {
        this.x = _x;
        this.endx = this.x;
        this.y = _y + 100;
        this.endy = this.y + 100;
        this.length = 100.0;
        this.rad = 0;
    }

    /**
     * 绘制
     *
     * @param g 画笔
     */
    public void paintSelf(Graphics g) {

        if (rad < 0.1)
            direction = 1;
        else if (rad > 0.9)
            direction = -1;
        rad = rad + 0.005 * direction;

        //计算末尾坐标
        this.endx = (int) (this.x + length * Math.cos(rad * Math.PI));
        this.endy = (int) (this.y + length * Math.sin(rad * Math.PI));

        g.setColor(Color.red);
        g.drawLine(this.x, this.y, this.endx, this.endy);
    }
}
