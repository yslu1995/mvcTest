package com.bean;

/**
 * @Author: yslu
 * @Date: 2019/7/3 6:43
 * @description：产品类
 */
public class Product {
    private int id;
    private String name;
    private String price;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
