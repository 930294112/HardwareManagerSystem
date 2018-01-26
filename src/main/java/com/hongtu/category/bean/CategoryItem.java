package com.hongtu.category.bean;

public class CategoryItem {
    private String cid;
    private String iid;

    public CategoryItem(String cid) {
        this.cid = cid;
    }

    public CategoryItem(String cid, String iid) {
        this.cid = cid;
        this.iid = iid;
    }

    @Override
    public String toString() {
        return "Category_Item{" +
                "cid='" + cid + '\'' +
                ", iid='" + iid + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }
}
