package com.hongtu.customer.bean;

public class Customer {
    private String cuid;
    private String cuname;
    private String cutel;

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cuid='" + cuid + '\'' +
                ", cuname='" + cuname + '\'' +
                ", cutel='" + cutel + '\'' +
                '}';
    }

    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public String getCuname() {
        return cuname;
    }

    public void setCuname(String cuname) {
        this.cuname = cuname;
    }

    public String getCutel() {
        return cutel;
    }

    public void setCutel(String cutel) {
        this.cutel = cutel;
    }

    public Customer(String cuid, String cuname, String cutel) {

        this.cuid = cuid;
        this.cuname = cuname;
        this.cutel = cutel;
    }
}
