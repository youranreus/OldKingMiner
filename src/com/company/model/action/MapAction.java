package com.company.model.action;

import com.company.model.entity.item;
import com.company.model.entity.mineral;

public interface MapAction {

    /**
     * 初始化地图
     */
    void init();

    /**
     * 获取地图中物体数量
     *
     * @return int number of item
     */
    int getItemNum();

    /**
     * 获取地图中物体
     *
     * @param _id 物体id
     * @return item 物体
     */
    item getItem(int _id);

    /**
     * 获取地图中物体
     *
     * @param _name 物体名
     * @return item 物体
     */
    item getItem(String _name);

    /**
     * 获取地图高度
     *
     * @return int height
     */
    int getHeight();

    /**
     * 获取地图宽度
     *
     * @return int width
     */
    int getWidth();

    /**
     * 判断是否已到达边界
     *
     * @param i 物体
     * @return boolean
     */
    boolean isEdge(item i);

    /**
     * 判断是否已到达边界
     *
     * @param _x x坐标
     * @param _y y坐标
     * @return boolean
     */
    boolean isEdge(int _x, int _y);

    /**
     * 获取地图中的物体
     *
     * @return mineral[] 物体集合
     */
    mineral[] getItems();
}
