package com.company.model.item;

public class player extends item {

    private final int balance;
    private final int hp;

    public player(String _name, int id) {
        super(_name, 0, 0, id);
        this.balance = 0;
        this.hp = 100;
    }

    /**
     * 获取玩家余额
     * @return int
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * 获取玩家血量
     * @return int
     */
    public int getHp() {
        return this.hp;
    }


}
