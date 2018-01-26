package com.hongtu.order.service;

import com.hongtu.order.bean.Order;
import com.hongtu.util.PageBean;

public interface OrderService {

    PageBean<Order> findAllOrder(String state, Integer pageNum, int pageSize);

    int updateState(String oid);


    PageBean<Order> findOrderByUid(String uid, Integer pageNum, int pageSize);

    Order findOrderById(String oid);

    int addCustomer(Order order);

    PageBean<Order> findOrderByCuid(String cuid, Integer pageNum, int pageSize);
}
