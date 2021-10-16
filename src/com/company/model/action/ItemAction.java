package com.company.model.action;

public interface ItemAction {

    /**
     * 移动物体
     *
     * @param _x 目标x
     * @param _y 目标y
     * @return boolean 移动是否成功
     */
    boolean move(int _x, int _y);

    /**
     * 删除物体
     *
     * @return boolean 删除是否成功
     */
    boolean destroy();
}
