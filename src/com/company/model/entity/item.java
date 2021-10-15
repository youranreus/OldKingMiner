package com.company.model.entity;

public class item extends entity {

    /**
     * item constructor
     */
    public item() {
        setName("unknown");
        setX(0);
        setY(0);
        setHeight(0);
        setWidth(0);
        setId(-1);
    }

    /**
     * item constructor
     */
    public item(String _name) {
        this();
        setName(_name);
    }

    /**
     * item constructor
     */
    public item(item i) {
        this();
        setName(i.getName());
        setHeight(i.getHeight());
        setWidth(i.getWidth());
    }

    /**
     * item constructor
     */
    public item(String _name, int h, int w, int id) {
        this();
        setName(_name);
        setHeight(h);
        setWidth(w);
        setId(id);
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    void setName(String _name) {
        name = _name;
    }

    @Override
    int getId() {
        return id;
    }

    @Override
    void setId(int _data) {
        id = _data;
    }

    @Override
    int getX() {
        return x;
    }

    @Override
    void setX(int _data) {
        x = _data;
    }

    @Override
    int getY() {
        return y;
    }

    @Override
    void setY(int _data) {
        y = _data;
    }

    @Override
    int getHeight() {
        return height;
    }

    @Override
    void setHeight(int _data) {
        height = _data;
    }

    @Override
    int getWidth() {
        return width;
    }

    @Override
    void setWidth(int _data) {
        width = _data;
    }

    void move(int _x, int _y) {
        setX(_x);
        setY(_y);
    }

}
