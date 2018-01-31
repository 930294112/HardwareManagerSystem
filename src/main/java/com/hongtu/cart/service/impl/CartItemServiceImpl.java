package com.hongtu.cart.service.impl;

import com.hongtu.cart.bean.CartItem;
import com.hongtu.cart.mapper.CartItemMapper;
import com.hongtu.cart.service.CartItemService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartItemServiceImpl  implements CartItemService{
    @Resource
    private CartItemMapper cartItemMapper;
    public CartItem findByIid(String iid) {
        return cartItemMapper.findByIid(iid);
    }

    public int insert(CartItem cartItem1) {
        return cartItemMapper.insert(cartItem1);
    }

    public int update(CartItem cartItem) {
        return cartItemMapper.update(cartItem);
    }

    public CartItem findByIidAdndUid(CartItem cartItem) {
        return cartItemMapper.findByIidAndUid(cartItem);
    }

    public List<CartItem> findAll(String uid) {
        return cartItemMapper.findAll(uid);
    }

    public List<CartItem> findByUid(String uid) {
        return cartItemMapper.findByUid(uid);
    }


}
