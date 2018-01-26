package com.hongtu.customer.service.impl;

import com.hongtu.customer.bean.Customer;
import com.hongtu.customer.mapper.CustomerMapper;
import com.hongtu.customer.service.CustomerService;
import com.hongtu.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    public PageBean<Customer> findAllCustomer(Integer pageNum, int pageSize) {
        int  totalCount = customerMapper.findCount();
        PageBean<Customer> pageBean = new PageBean<Customer>(pageNum,pageSize,totalCount);
        List<Customer> customers = customerMapper.findAll(pageBean);
        pageBean.setData(customers);
        return pageBean;
    }

    public int save(Customer customer) {
        //根据名称查询单位名称是否已经存在
        int count=0;
        Customer byName = customerMapper.findByName(customer.getCuname());
        if (byName==null){
             count = customerMapper.save(customer);
            return count;
        }else {
            return count;
        }

    }

    public List<Integer> deleteByIds(String[] deleteIds) {
        int count = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (String deleteId : deleteIds) {
            count = customerMapper.deleteById(deleteId);
            if (count > 0){
                list.add(count);
            }
        }
        return list;
    }

    public List<Customer> findAllCustomerNoPage() {
        return customerMapper.findAllCustomerNoPage();
    }

    public PageBean<Customer> query(Customer customer, Integer pageNum, int pageSize) {
        int totalCount = customerMapper.findCountQueyr(customer);
        PageBean<Customer> pageBean = new PageBean<Customer>(pageNum,pageSize,totalCount);
       pageBean.setCondition(customer.getCuname());
        List<Customer> customers = customerMapper.query(pageBean);
        pageBean.setData(customers);
        return pageBean;

    }
}
