package com.company.model.entity;

public class player extends item {

    private int balance;
    private int hp;

    public player(String _name, int id) {
        super(_name, 0, 0, id);
        this.balance = 0;
        this.hp = 100;
    }

}
