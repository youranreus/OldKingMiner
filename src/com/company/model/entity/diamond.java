package com.company.model.entity;

import com.company.utils.utils;

import java.awt.*;

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
        this.img = Toolkit.getDefaultToolkit().getImage("assets/img/diamond.png");
        if (size == 1)
            this.price = 1000;
        else if (size == 2)
            this.price = 2000;
        else
            this.price = 6000;
    }

    /**
     * 钻石生成深度: 600~800
     */
    @Override
    void generate() {
        super.generate();
        this.setY(utils.random(600,800));
    }
}
