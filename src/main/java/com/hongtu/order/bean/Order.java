package com.hongtu.order.bean;

import com.hongtu.customer.bean.Customer;
import com.hongtu.user.bean.User;

import java.sql.Timestamp;
import java.util.List;


public class Order {
    private String oid;//订单编号
    private double subtotal;//订单总价
    private String state;//订单状态 1 下单，未发货；2发货运输中；3货到没确认收货；4确认收货订单完成
    private String address;//订单地址
    private String context;//订单留言
    private Timestamp ordertime;//订单时间
    private String uid;
    private String cuid;
    private List<OrderItem> orderItemList;//一条订单包含的订单

    private User user;//订单对应的用户

    private Customer customer;//订单所对应的公司


    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", subtotal=" + subtotal +
                ", state=" + state +
                ", address='" + address + '\'' +
                ", context='" + context + '\'' +
                ", ordertime=" + ordertime +
                '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    public Order(String oid, double subtotal, String state, String address, String context, Timestamp ordertime, String uid, List<OrderItem> orderItemList, User user) {
        this.oid = oid;
        this.subtotal = subtotal;
        this.state = state;
        this.address = address;
        this.context = context;
        this.ordertime = ordertime;
        this.uid = uid;
        this.orderItemList = orderItemList;
        this.user = user;
    }

    public Order(String oid, double subtotal, String state, String address, String context, Timestamp ordertime, String uid) {
        this.oid = oid;
        this.subtotal = subtotal;
        this.state = state;
        this.address = address;
        this.context = context;
        this.ordertime = ordertime;
        this.uid = uid;
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Order() {

    }
}
