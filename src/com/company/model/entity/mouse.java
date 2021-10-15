package com.company.model.entity;

public class mouse extends item{

    /**
     * 老鼠价值：2~10
     */
    private final int price;

    /**
     * mouse constructor
     * @param _name 实体名称
     * @param _id 实体id
     */
    public mouse(String _name, int _id) {
        super(_name, 0, 0, _id);

        /*
          随机生成老鼠价值
         */
        this.price = (int)(1+Math.random()*(10-2+1));
    }

    /**
     * 获取老鼠价值
     * @return int price
     */
    public int getPrice() {
        return price;
    }
}
