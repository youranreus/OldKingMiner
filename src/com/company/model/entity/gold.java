package com.company.model.entity;

public class gold extends item {

    /**
     * 金矿大小
     * 大：3
     * 中：2
     * 小：1
     */
    private final int size;

    /**
     * 金矿价值
     * 100-300-600
     */
    private final int price;

    /**
     * gold constructor
     *
     * @param _name 物品名
     * @param _id id
     * @param _size 物体大小
     */
    gold(String _name, int _id, int _size) {
        super(_name, 0, 0, _id);
        this.size = _size;
        if (size == 1)
            this.price = 100;
        else if (size == 2)
            this.price = 300;
        else
            this.price = 600;
    }

    /**
     * 获取金矿大小
     * @return int size
     */
    int getSize() {
        return size;
    }

    /**
     * 获取金矿价值
     * @return int price
     */
    int getPrice() {
        return price;
    }



}
