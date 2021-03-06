package com.company.model.action;

import com.company.model.entity.mineral;

public interface PlayerAction {

    /**
     * 玩家移动（只能在x轴移动）
     *
     * @param step 步数(左减右加)
     * @return boolean 是否移动成功
     */
    boolean move(int step);

    /**
     * 玩家放下钩子（绳子）
     */
    void dropTheLine();

    /**
     * 设置绳子的矿物检测
     */
    void setLineMineral(mineral[] _m);

}
