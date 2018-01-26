package com.hongtu.user.bean.ext;


import com.hongtu.user.bean.User;

/**
 * Created by dllo on 17/12/13.
 */
public class ExtUser extends User {
    private String name;
    private String datemin;
    private String datemax;

    public ExtUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatemin() {
        return datemin;
    }

    public void setDatemin(String datemin) {
        this.datemin = datemin;
    }

    public String getDatemax() {
        return datemax;
    }

    public void setDatemax(String datemax) {
        this.datemax = datemax;
    }
}
