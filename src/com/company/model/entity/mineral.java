package com.company.model.entity;

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
     * gold constructor
     *
     * @param _name 物品名
     * @param _id id
     * @param _size 物体大小
     */
    mineral(String _name, int _id, int _size) {
        super(_name, 0, 0, _id);
        this.size = _size;
    }

    /**
     * 获取矿物大小
     * @return int size
     */
    int getSize() {
        return size;
    }

    /**
     * 获取矿物价值
     * @return int price
     */
    int getPrice() {
        return price;
    }

}