package com.company.utils;

public class utils {

    /**
     * 随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @return int 随机数
     */
    public static int random(int min, int max) {
        return (int) (Math.random()*(max-min)+min);
    }

}
