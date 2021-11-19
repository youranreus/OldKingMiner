package com.company.model.entity;

import java.awt.*;

public class hook extends item{

    /**
     * 钩子下落中
     */
    private boolean dropping;

    /**
     * 钩爪图片
     */
    private Image bg = Toolkit.getDefaultToolkit().getImage("assets/img/hook.png");

    /**
     * hook constructor.
     * 生成在玩家下方。
     *
     * @param _name 所属玩家名
     * @param _x 玩家坐标x
     * @param _y 玩家坐标y
     */
    public hook(String _name, int _x, int _y) {
        super(_name+"`s hook");
        setX(_x);
        setY(_y);
        setWidth(19);
        setHeight(32);
        this.dropping = false;
    }

    /**
     * 下落
     *
     * @return dropped
     */
    public boolean drop() {
        if (this.dropping)
            return false;

        this.dropping = true;
        return true;
    }

    /**
     * 绘制
     */
    public void painSelf(Graphics g) {
        g.drawImage(bg, this.x, this.y,null);
    }

    /**
     * 设置x,y
     * @param x x
     * @param y y
     */
    public void setXY(int x, int y) {
        this.x = x - 9;
        this.y = y - 2;
    }

}
