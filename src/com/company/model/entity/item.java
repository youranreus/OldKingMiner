package com.company.model.entity;

import com.company.model.action.ItemAction;

public class item extends entity implements ItemAction{

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
     * @param _name 物体名称
     */
    public item(String _name) {
        this();
        setName(_name);
    }

    /**
     * item constructor
     * @param i 复制对象
     */
    public item(item i) {
        this();
        setName(i.getName());
        setHeight(i.getHeight());
        setWidth(i.getWidth());
    }

    /**
     * item constructor
     * @param _name 物体名称
     * @param h 物体高度
     * @param w 物体宽度
     * @param id 物体id
     */
    public item(String _name, int h, int w, int id) {
        this();
        setName(_name);
        setHeight(h);
        setWidth(w);
        setId(id);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String _name) {
        name = _name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int _data) {
        id = _data;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int _data) {
        x = _data;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int _data) {
        y = _data;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int _data) {
        height = _data;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int _data) {
        width = _data;
    }

    /**
     * 移动物体
     *
     * @param _x 目标x
     * @param _y 目标y
     * @return boolean 移动是否成功
     */
    public boolean move(int _x, int _y) {
        try {
            setX(_x);
            setY(_y);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * 删除物体
     *
     * @return boolean 删除成功
     */
    public boolean destroy() {
        return true;
    }

}
