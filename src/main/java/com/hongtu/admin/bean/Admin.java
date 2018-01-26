package com.hongtu.admin.bean;



public class Admin{
    private String aid;
   private String aname;
   private String apwd;
   private String newpwd;
   private String repwd;

    @Override
    public String toString() {
        return "Admin{" +
                "aid='" + aid + '\'' +
                ", aname='" + aname + '\'' +
                ", apwd='" + apwd + '\'' +
                ", newpwd='" + newpwd + '\'' +
                ", repwd='" + repwd + '\'' +
                '}';
    }

    public Admin(String aid, String aname, String apwd, String newpwd, String repwd) {
        this.aid = aid;
        this.aname = aname;
        this.apwd = apwd;
        this.newpwd = newpwd;
        this.repwd = repwd;
    }

    public String getNewpwd() {

        return newpwd;
    }

    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }

    public String getRepwd() {
        return repwd;
    }

    public void setRepwd(String repwd) {
        this.repwd = repwd;
    }

    public Admin() {

    }

    public Admin(String aid, String aname, String apwd) {

        this.aid = aid;
        this.aname = aname;
        this.apwd = apwd;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }
}
