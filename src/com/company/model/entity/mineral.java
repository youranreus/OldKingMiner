package com.company.model.entity;

import com.company.utils.utils;

import java.awt.*;

public class mineral extends item{

    /**
     * 矿物大小
     * 大：3
     * 中：2
     * 小：1
     */
    protected int size;

    /**
     * 矿物价值
     */
    protected int price;

    /**
     * 矿物图片
     */
    protected Image img;

    /**
     * mineral constructor
     *
     * @param _name 物品名
     * @param _id id
     * @param _size 物体大小
     */
    mineral(String _name, int _id, int _size) {
        super(_name, 0, 0, _id);
        this.size = _size;
        this.name = "矿物";
        this.generate();
    }

    /**
     * 获取矿物大小
     * @return int size
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取矿物价值
     * @return int price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 生成矿物位置
     */
    void generate() {
        this.setX(utils.random(0,800));
    }

    /**
     * 绘制
     */
    public void painSelf(Graphics g) {
        g.drawImage(img, this.x, this.y,null);
    }

}
