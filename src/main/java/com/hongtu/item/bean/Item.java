package com.hongtu.item.bean;

import com.hongtu.category.bean.Category;

public class Item {
    private String iid;
    private String iname;
    private Double price;
    private Double viprice;
    private String image;
    private String cid;
    private int stock; //商品的库存
    private int sales; //商品的销量
    private String des;//商品详细信息

    private String cname; //商品对应的分类
    private Category category;//商品对应的分类

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Item() {
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Item(String iid, String iname, Double price, Double viprice, String image, String cid, int stock, int sales, String des, String cname, Category category) {
        this.iid = iid;
        this.iname = iname;
        this.price = price;
        this.viprice = viprice;
        this.image = image;
        this.cid = cid;
        this.stock = stock;
        this.sales = sales;
        this.des = des;
        this.cname = cname;
        this.category = category;
    }

    public Item(String iid, String iname, Double price, Double viprice, String image, String cid, int stock, int sales, String des, String cname) {
        this.iid = iid;
        this.iname = iname;
        this.price = price;
        this.viprice = viprice;
        this.image = image;
        this.cid = cid;
        this.stock = stock;
        this.sales = sales;
        this.des = des;
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Item{" +
                "iid='" + iid + '\'' +
                ", iname='" + iname + '\'' +
                ", price=" + price +
                ", viprice=" + viprice +
                ", image='" + image + '\'' +
                ", cid='" + cid + '\'' +
                ", stock=" + stock +
                ", sales=" + sales +
                ", des='" + des + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getViprice() {
        return viprice;
    }

    public void setViprice(Double viprice) {
        this.viprice = viprice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
