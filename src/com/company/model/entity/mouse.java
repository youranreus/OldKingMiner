package com.company.model.entity;

public class mouse extends item{

    /**
     * 老鼠价值：2~10
     */
    private final int price;

    public mouse(String _name, int id) {
        super(_name, 0, 0, id);
        this.price = (int)(1+Math.random()*(10-2+1));
    }

}
