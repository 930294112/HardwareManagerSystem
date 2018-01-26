package com.hongtu.order.bean;

import com.hongtu.item.bean.Item;

public class OrderItem {
    private String oiid;//小订单id
    private double total;//小计
    private int count;//数量
    private String iid;//对应的商品
    private String oid;//对应的订单

    private Item item;//订单下对应的商品

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "oiid='" + oiid + '\'' +
                ", total=" + total +
                ", count=" + count +
                ", iid='" + iid + '\'' +
                ", oid='" + oid + '\'' +
                '}';
    }

    public String getOiid() {
        return oiid;
    }

    public void setOiid(String oiid) {
        this.oiid = oiid;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public OrderItem() {

    }

    public OrderItem(String oiid, double total, int count, String iid, String oid) {

        this.oiid = oiid;
        this.total = total;
        this.count = count;
        this.iid = iid;
        this.oid = oid;
    }
}
