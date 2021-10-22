package com.company.model.map;

import com.company.model.entity.diamond;
import com.company.model.entity.gold;
import com.company.model.entity.rock;
import com.company.utils.utils;
import com.company.model.entity.item;
import com.company.model.action.MapAction;

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
    private item[] items;

    /**
     * 地图等级（与关卡等级同步）
     */
    private final int level;

    public map(int _level) {
        this.height = 50;
        this.width = 70;
        this.level = _level;
    }

    @Override
    public void init() {
        int id_counter = 100;
        int rand = utils.random(0,30) + this.level;
        this.items = new item[rand];
        for(int i = 0;i<rand;i++)
        {
            int type = utils.random(1,3);
            switch (type) {
                case 1 -> this.items[i] = new rock("岩石", id_counter + i, utils.random(1, 3));
                case 2 -> this.items[i] = new gold("金矿", id_counter + i, utils.random(1, 3));
                case 3 -> this.items[i] = new diamond("钻石", id_counter + i, utils.random(1, 3));
            }
        }


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

}
