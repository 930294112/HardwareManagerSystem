package com.hongtu.order.mapper;

import com.hongtu.order.bean.Order;
import com.hongtu.util.PageBean;

import java.util.List;

public interface OrderMapper {
    int findCount();

    List<Order> findAll(PageBean<Order> pageBean);

    int updateState(String oid);

    int findCountByUid(String uid);

    List<Order> findByUid(PageBean<Order> pageBean);

    Order findById(String oid);

    int addCustomer(Order order);

    int findCountByCuid(String cuid);

    List<Order> findByCuid(PageBean<Order> pageBean);
}
