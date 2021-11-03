package com.company.model.map;

import java.awt.*;

public class background {

    /**
     * 图片载入
     */
    Image background = Toolkit.getDefaultToolkit().getImage("assets/img/bg.png");

    /**
     * 绘制
     *
     * @param g 画笔
     */
    public void painSelf(Graphics g) {
        g.drawImage(this.background, 0,0,null);
        g.drawImage(this.background, 0,400,null);
    }
}
