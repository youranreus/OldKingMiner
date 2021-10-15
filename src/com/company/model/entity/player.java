package com.company.model.entity;

public class player extends item {

    /**
     * 玩家余额
     */
    private final int balance;

    /**
     * 玩家生命值
     */
    private final int hp;

    /**
     * player constructor
     * @param _name 玩家名
     * @param id 玩家id
     */
    public player(String _name, int id) {
        super(_name, 0, 0, id);
        this.balance = 0;
        this.hp = 100;
    }

    /**
     * 获取玩家余额
     * @return int balance
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * 获取玩家血量
     * @return int hp
     */
    public int getHp() {
        return this.hp;
    }

}
