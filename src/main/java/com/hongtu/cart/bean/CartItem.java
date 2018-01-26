package com.hongtu.cart.bean;

import com.hongtu.item.bean.Item;

import java.io.Serializable;

public class CartItem implements Serializable{
    private int count;
    private Item item;

    @Override
    public String toString() {
        return "CartItem{" +
                "count=" + count +
                ", item=" + item +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public CartItem() {

    }

    public CartItem(int count, Item item) {

        this.count = count;
        this.item = item;
    }
}
