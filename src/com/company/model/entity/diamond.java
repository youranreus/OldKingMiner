package com.company.model.entity;

public class diamond extends mineral{

    /**
     * diamond constructor
     *
     * @param _name 物品名
     * @param _id id
     * @param _size 物体大小
     */
    public diamond(String _name, int _id, int _size) {
        super(_name, _id, _size);
        this.size = _size;
        if (size == 1)
            this.price = 1000;
        else if (size == 2)
            this.price = 2000;
        else
            this.price = 6000;
    }

}
