package com.hongtu.user.bean;

public class Adress {
    private String adid;
    private String aname;
    private String uid;

    public Adress() {
    }

    @Override
    public String toString() {
        return "Adress{" +
                "adid='" + adid + '\'' +
                ", aname='" + aname + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Adress(String adid, String aname, String uid) {

        this.adid = adid;
        this.aname = aname;
        this.uid = uid;
    }
}
