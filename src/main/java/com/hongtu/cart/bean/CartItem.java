package com.hongtu.cart.bean;

import com.hongtu.item.bean.Item;

import java.io.Serializable;

public class CartItem implements Serializable{
    private String id;//id
    private int count;//商品的数量
    private String iid;//对应的商品id
    private Item item;//对应的商品
    private String uid;//对应的用户

    @Override
    public String toString() {
        return "CartItem{" +
                "id='" + id + '\'' +
                ", count=" + count +
                ", iid='" + iid + '\'' +
                ", item=" + item +
                ", uid='" + uid + '\'' +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public CartItem(String id, int count, String iid, String uid) {

        this.id = id;
        this.count = count;
        this.iid = iid;
        this.uid = uid;
    }

    public CartItem(String id, int count, String iid) {
        this.id = id;
        this.count = count;
        this.iid = iid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
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
