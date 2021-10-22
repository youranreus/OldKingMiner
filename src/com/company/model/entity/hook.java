package com.company.model.entity;

public class hook extends item{

    /**
     * hook constructor.
     * 生成在玩家下方。
     *
     * @param _name 所属玩家名
     * @param _x 玩家坐标x
     * @param _y 玩家坐标y
     */
    public hook(String _name, int _x, int _y) {
        super(_name+"`s hook");
        setX(_x);
        setY(_y - 1);
        setWidth(1);
        setHeight(1);
    }

}
