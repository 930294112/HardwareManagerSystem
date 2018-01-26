package com.hongtu.order.mapper;

import com.hongtu.order.bean.OrderItem;

import java.util.List;

public interface OderItemMapper {
    List<OrderItem> findByOid(String oid);
}
