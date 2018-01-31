package com.hongtu.cart.bean;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String,CartItem> cartItemMap = new HashMap<String, CartItem>();

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItemMap=" + cartItemMap +
                '}';
    }

    public Map<String, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<String, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Cart(Map<String, CartItem> cartItemMap) {

        this.cartItemMap = cartItemMap;
    }
}
