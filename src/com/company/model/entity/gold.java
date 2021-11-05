package com.company.model.entity;

import com.company.utils.utils;

import java.awt.*;

public class gold extends mineral {

    /**
     * gold constructor
     *
     * @param _name 物品名
     * @param _id   id
     * @param _size 物体大小
     */
    public gold(String _name, int _id, int _size) {
        super(_name, _id, _size);
        this.size = _size;
        if (size == 1) {
            this.price = 100;
            this.img = Toolkit.getDefaultToolkit().getImage("assets/img/gold0.gif");
        } else if (size == 2) {
            this.price = 300;
            this.img = Toolkit.getDefaultToolkit().getImage("assets/img/gold1.gif");
        } else {
            this.price = 600;
            this.img = Toolkit.getDefaultToolkit().getImage("assets/img/gold2.gif");
        }
    }

    /**
     * 金矿生成深度为200~800
     */
    @Override
    void generate() {
        super.generate();
        this.setY(utils.random(200, 800));
    }
}
