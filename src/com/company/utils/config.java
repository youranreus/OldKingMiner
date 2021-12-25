package com.company.utils;

public class config {

    /**
     * 版本
     */
    public static final String VERSION = "1.0.0";

    /**
     * 调试模式
     */
    public static final boolean DEBUG = true;

    /**
     * 在线模式
     * 0 => 本地模式
     * 1 => 主机模式
     * 2 => 联机模式
     */
    public static int online = 0;

    /**
     * 需要连接到的服务器地址
     */
    public static final String server = "127.0.0.1";

    /**
     * 需要连接到的服务器端口
     */
    public static final int port = 4700;

    /**
     * 玩家人数
     */
    public static int players = 2;

    /**
     * 是否过关
     */
    public static boolean passed = false;

    /**
     * 是否打开音效
     */
    public static boolean sound = true;

}
