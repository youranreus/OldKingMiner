package com.company;

import com.company.controller.GameController;
import com.company.controller.GameProcessController;
import com.company.utils.PlayWav;

import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        new PlayWav("D:\\CODE\\PROJECTS\\OldKingMiner\\assets\\media\\start.wav");
        //----------------------------------
        // 游戏基本信息对象
        // 包含
        // - 游戏人数
        // - 游戏关卡
        // - 游戏时长
        // - 游戏地图
        // - 游戏目标分
        // - 其他
        //----------------------------------
        GameController game = new GameController(2);

        //----------------------------------
        // 游戏进程控制器
        // 网络连接
        // 关卡
        // GUI
        //----------------------------------
        GameProcessController c = new GameProcessController(game);
    }
}
