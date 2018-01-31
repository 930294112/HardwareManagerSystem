package com.hongtu.cart.mapper;

import com.hongtu.cart.bean.CartItem;

import java.util.List;

public interface CartItemMapper {
    CartItem findByIid(String iid);

    int insert(CartItem cartItem1);

    int update(CartItem cartItem);

   CartItem findByIidAndUid(CartItem cartItem);

    List<CartItem> findAll(String uid);

    List<CartItem> findByUid(String uid);
}
