package com.company.model.action;

public interface PlayerAction {

    /**
     * 玩家移动（只能在x轴移动）
     *
     * @param step 步数(左减右加)
     * @return boolean 是否移动成功
     */
    boolean move(int step);

    /**
     * 玩家下放钩子
     *
     * @return boolean
     */
    boolean dropTheHook();

}
