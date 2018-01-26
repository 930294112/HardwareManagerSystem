package com.hongtu.user.bean;

import java.sql.Timestamp;
import java.util.List;

public class User {
    private String uid;
    private String loginame;
    private String realname;
    private String image;
    private String tel;
//    private String address;
    private Timestamp create_time;
    private List<Adress> adresses;

    public List<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adress> adresses) {
        this.adresses = adresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", loginame='" + loginame + '\'' +
                ", realname='" + realname + '\'' +
                ", image='" + image + '\'' +
                ", tel='" + tel + '\'' +
                ", create_time=" + create_time +
                ", adresses=" + adresses +
                '}';
    }

    public User(String uid, String loginame, String realname, String image, String tel, Timestamp create_time, List<Adress> adresses) {
        this.uid = uid;
        this.loginame = loginame;
        this.realname = realname;
        this.image = image;
        this.tel = tel;
        this.create_time = create_time;
        this.adresses = adresses;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLoginame() {
        return loginame;
    }

    public void setLoginame(String loginame) {
        this.loginame = loginame;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }



    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public User() {

    }
}


