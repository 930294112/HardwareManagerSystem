package com.hongtu.cart.service.impl;

import com.hongtu.cart.mapper.CartMapper;
import com.hongtu.cart.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartMapper cartMapper;
}
