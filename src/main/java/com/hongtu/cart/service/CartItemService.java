package com.hongtu.cart.service;

import com.hongtu.cart.bean.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem findByIid(String iid);

    int insert(CartItem cartItem1);

    int update(CartItem cartItem);

    CartItem findByIidAdndUid(CartItem cartItem);

    List<CartItem> findAll(String uid);

    List<CartItem> findByUid(String uid);
}
