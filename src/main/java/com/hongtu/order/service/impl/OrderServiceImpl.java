package com.hongtu.order.service.impl;

import com.hongtu.customer.bean.Customer;
import com.hongtu.customer.mapper.CustomerMapper;
import com.hongtu.order.bean.Order;
import com.hongtu.order.bean.OrderItem;
import com.hongtu.order.mapper.OderItemMapper;
import com.hongtu.order.mapper.OrderMapper;
import com.hongtu.order.service.OrderService;
import com.hongtu.user.bean.User;
import com.hongtu.user.mapper.UserMapper;
import com.hongtu.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OderItemMapper oderItemMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private UserMapper userMapper;


    public PageBean<Order> findAllOrder(String state,Integer pageNum, int pageSize) {
        int totalCount = orderMapper.findCount();
        PageBean<Order> pageBean = new PageBean<Order>(pageNum,pageSize,totalCount);
        //加入查询条件
        pageBean.setCondition(state);
        List<Order> orders = orderMapper.findAll(pageBean);
            for (Order order : orders) {
            List<OrderItem> orderItems = oderItemMapper.findByOid(order.getOid());
            order.setOrderItemList(orderItems);

        }
        pageBean.setData(orders);
        return pageBean;
    }

    public int updateState(String oid) {
        int count = orderMapper.updateState(oid);
        return count;
    }

    public PageBean<Order> findOrderByUid(String uid,Integer pageNum,int pageSize) {
        int totalCount = orderMapper.findCountByUid(uid);
        PageBean<Order> pageBean = new PageBean<Order>(pageNum,pageSize,totalCount);
        //加入查询条件
        pageBean.setCondition(uid);
        List<Order> orders = orderMapper.findByUid(pageBean);
        for (Order order : orders) {
            List<OrderItem> orderItems = oderItemMapper.findByOid(order.getOid());
            order.setOrderItemList(orderItems);
            pageBean.setCondition(order.getUser().getUid());
            Customer customer = customerMapper.findById(order.getCuid());
            order.setCustomer(customer);
        }
        pageBean.setData(orders);

        return pageBean;
    }

    public PageBean<Order> findOrderByCuid(String cuid, Integer pageNum, int pageSize) {
        int totalCount = orderMapper.findCountByCuid(cuid);
        PageBean<Order> pageBean = new PageBean<Order>(pageNum,pageSize,totalCount);
        //加入查询条件
        pageBean.setCondition(cuid);
        List<Order> orders = orderMapper.findByCuid(pageBean);
        for (Order order : orders) {
            //查到一条订单下的小订单
            List<OrderItem> orderItems = oderItemMapper.findByOid(order.getOid());
            order.setOrderItemList(orderItems);
            //根据uid查到订货人
            User user = userMapper.findById(order.getUid());
            order.setUser(user);
            pageBean.setCondition(order.getCustomer().getCuname());

        }

        pageBean.setData(orders);
        return pageBean;
    }



    public Order findOrderById(String oid) {
        Order order = orderMapper.findById(oid);
        Customer customer = customerMapper.findById(order.getCuid());
        order.setCustomer(customer);
        List<OrderItem> orderItems = oderItemMapper.findByOid(oid);
        order.setOrderItemList(orderItems);
        return order;
    }

    public int addCustomer(Order order) {
       return orderMapper.addCustomer(order);

    }


}
