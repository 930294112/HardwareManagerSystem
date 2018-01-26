package com.hongtu.customer.mapper;

import com.hongtu.customer.bean.Customer;
import com.hongtu.order.bean.Order;
import com.hongtu.util.PageBean;

import java.util.List;

public interface CustomerMapper {
    int findCount();

    List<Customer> findAll(PageBean<Customer> pageBean);

    Customer findByName(String cuname);

    int save(Customer customer);

    int deleteById(String deleteId);

    List<Customer> findAllCustomerNoPage();

    Customer findById(String cuid);



    List<Customer> query(PageBean<Customer> pageBean);

    int findCountQueyr(Customer customer);
}
