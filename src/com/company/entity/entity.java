package com.company.entity;

public abstract class entity {

    /**
     * 实体id
     */
    protected int id;

    /**
     * 实体名称
     */
    protected String name;

    /**
     * 实体坐标x
     */
    protected int x;

    /**
     * 实体坐标y
     */
    protected int y;

    /**
     * 实体高度
     */
    protected int height;

    /**
     * 实体宽度
     */
    protected int width;

    /**
     * 获取实体名称
     * @return String
     */
    abstract String getName();

    /**
     * 设置实体名称
     */
    abstract void setName(String _name);

    /**
     * 获取实体坐标x
     * @return int
     */
    abstract int getX();

    /**
     * 设置实体坐标x
     */
    abstract void setX(int _data);

    /**
     * 获取实体坐标y
     * @return int
     */
    abstract int getY();

    /**
     * 设置实体坐标y
     */
    abstract void setY(int _data);

    /**
     * 获取实体id
     * @return int
     */
    abstract int getId();

    /**
     * 设置实体id
     */
    abstract void setId(int _data);

    /**
     * 获取实体高度
     * @return int
     */
    abstract int getHeight();

    /**
     * 设置实体高度
     */
    abstract void setHeight(int _data);

    /**
     * 获取实体宽度
     * @return int
     */
    abstract int getWidth();

    /**
     * 设置实体宽度
     */
    abstract void setWidth(int _data);
}
