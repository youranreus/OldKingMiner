package com.company.model.entity;

public abstract class entity {
    protected int id;
    protected String name;
    protected int x;
    protected int y;
    protected int height;
    protected int width;

    abstract String getName();

    abstract void setName(String _name);

    abstract int getX();

    abstract void setX(int _data);

    abstract int getY();

    abstract void setY(int _data);

    abstract int getId();

    abstract void setId(int _data);

    abstract int getHeight();

    abstract void setHeight(int _data);

    abstract int getWidth();

    abstract void setWidth(int _data);
}
