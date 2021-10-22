package com.company.model.entity;

public class rock extends mineral{

    /**
     * rock constructor
     *
     * @param _name 物品名
     * @param _id   id
     * @param _size 物体大小
     */
    public rock(String _name, int _id, int _size) {
        super(_name, _id, _size);
        this.size = _size;
        if (size == 1)
            this.price = 10;
        else if (size == 2)
            this.price = 30;
        else
            this.price = 60;
    }
}
