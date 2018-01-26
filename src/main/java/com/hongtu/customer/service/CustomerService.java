package com.hongtu.customer.service;

import com.hongtu.customer.bean.Customer;
import com.hongtu.util.PageBean;

import java.util.List;

public interface CustomerService {
    PageBean<Customer> findAllCustomer(Integer pageNum, int pageSize);

    int save(Customer customer);

    List<Integer> deleteByIds(String[] deleteIds);

    List<Customer> findAllCustomerNoPage();

    PageBean<Customer> query(Customer customer, Integer pageNum, int pageSize);
}
