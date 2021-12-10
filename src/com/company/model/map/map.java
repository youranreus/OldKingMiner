package com.company.model.map;

import com.company.model.entity.*;
import com.company.utils.config;
import com.company.utils.utils;
import com.company.model.action.MapAction;

import java.util.Arrays;
import java.util.Objects;

public class map implements MapAction {

    /**
     * 地图高度
     */
    private final int height;

    /**
     * 地图宽度
     */
    private final int width;

    /**
     * 地图中物体
     */
    private mineral[] items;

    /**
     * 地图等级（与关卡等级同步）
     */
    private final int level;

    public map(int _level) {
        this.height = 800;
        this.width = 800;
        this.level = _level;
    }

    @Override
    public void init() {
        int id_counter = 100;
        int rand = utils.random(30, 40 + this.level);
        //本地模式时随机生成地图
        if(config.online == 0) {
            this.items = new mineral[rand];
            for (int i = 0; i < rand; i++) {
                int type = utils.random(10, 400);
                if (type < 100)
                    this.items[i] = new diamond("钻石", id_counter + i, utils.random(1, 3));
                else if (type < 250)
                    this.items[i] = new gold("金矿", id_counter + i, utils.random(1, 3));
                else
                    this.items[i] = new rock("岩石", id_counter + i, utils.random(1, 3));
            }
        }
        else { //联机模式固定地图
            this.items = new mineral[35];
            //x(0, 800) y(200, 800)
            this.items[0] = new rock("岩石", 101, 2, 100, 200);
            this.items[1] = new rock("岩石", 102, 1, 50, 210);
            this.items[2] = new rock("岩石", 103, 3, 150, 250);
            this.items[3] = new rock("岩石", 104, 2, 190, 300);
            this.items[4] = new rock("岩石", 105, 1, 400, 700);
            this.items[5] = new rock("岩石", 106, 2, 450, 310);
            this.items[6] = new rock("岩石", 107, 3, 700, 452);
            this.items[7] = new rock("岩石", 108, 2, 720, 670);
            this.items[8] = new rock("岩石", 109, 1, 237, 782);
            this.items[9] = new rock("岩石", 110, 3, 132, 563);
            this.items[10] = new rock("岩石", 111, 2, 632, 200);
            this.items[11] = new rock("岩石", 112, 1, 550, 440);
            this.items[12] = new rock("岩石", 113, 1, 300, 200);
            this.items[13] = new rock("岩石", 114, 1, 512, 343);
            this.items[14] = new rock("岩石", 115, 2, 114, 514);
            this.items[15] = new rock("岩石", 116, 3, 324, 240);
            //x(0, 800) y(200, 800)
            this.items[16] = new gold("金矿", 117, 2, 234, 500);
            this.items[17] = new gold("金矿", 118, 1, 102, 432);
            this.items[18] = new gold("金矿", 119, 3, 324, 475);
            this.items[19] = new gold("金矿", 120, 2, 569, 764);
            this.items[20] = new gold("金矿", 121, 3, 746, 576);
            this.items[21] = new gold("金矿", 122, 1, 467, 687);
            this.items[22] = new gold("金矿", 123, 2, 577, 254);
            this.items[23] = new gold("金矿", 124, 3, 666, 752);
            this.items[24] = new gold("金矿", 125, 3, 773, 534);
            this.items[25] = new gold("金矿", 126, 1, 353, 572);
            //x(0, 800) y(600, 800)
            this.items[26] = new diamond("钻石", 127, 2, 100, 600);
            this.items[27] = new diamond("钻石", 128, 1, 325, 632);
            this.items[28] = new diamond("钻石", 129, 1, 467, 653);
            this.items[29] = new diamond("钻石", 130, 3, 753, 654);
            this.items[30] = new diamond("钻石", 131, 1, 254, 666);
            this.items[31] = new diamond("钻石", 132, 3, 546, 783);
            this.items[32] = new diamond("钻石", 133, 2, 652, 600);
            this.items[33] = new diamond("钻石", 134, 3, 666, 764);
            this.items[34] = new diamond("钻石", 135, 1, 431, 640);
        }

        if (config.DEBUG)
            System.out.println(this);
    }

    @Override
    public int getItemNum() {
        return this.items.length;
    }

    @Override
    public item getItem(int _id) {
        for (item i : this.items)
            if (i.getId() == _id)
                return i;
        return null;
    }

    @Override
    public item getItem(String _name) {
        for (item i : this.items)
            if (Objects.equals(i.getName(), _name))
                return i;
        return null;
    }

    @Override
    public boolean isEdge(item i) {
        return (i.getX() <= 0 || i.getY() <= 0 || i.getX() >= this.width || i.getY() >= this.height);
    }

    @Override
    public boolean isEdge(int _x, int _y) {
        return (_x <= 0 || _y <= 0 || _x >= this.width || _y >= this.height);
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("地图生成状态：\n" + "物体个数：" + this.getItemNum() + "\n物体：");
        for (mineral i : this.items)
            result.append("[").append(i.getName()).append("#").append(i.getId()).append("]\n").append("价格: ").append(i.getPrice()).append("\n大小: ").append(i.getSize()).append("\n位置：(").append(i.getX()).append(", ").append(i.getY()).append(")\n");
        return result.toString();
    }

    /**
     * 获取地图中的物体
     *
     * @return mineral[] 物体集合
     */
    public mineral[] getItems() {
        return this.items;
    }
}
