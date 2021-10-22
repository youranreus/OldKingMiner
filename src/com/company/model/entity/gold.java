package com.company.model.entity;

public class gold extends mineral {

    /**
     * gold constructor
     *
     * @param _name 物品名
     * @param _id id
     * @param _size 物体大小
     */
    gold(String _name, int _id, int _size) {
        super(_name, _id, _size);
        this.size = _size;
        if (size == 1)
            this.price = 100;
        else if (size == 2)
            this.price = 300;
        else
            this.price = 600;
    }

}
