package com.hongtu.cart.controller;

import com.hongtu.cart.bean.CartItem;
import com.hongtu.cart.service.CartItemService;
import com.hongtu.item.bean.Item;
import com.hongtu.item.service.ItemService;
import com.hongtu.user.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class CartController {
    @Resource
    private CartItemService cartItemService;
    @Resource
    private ItemService itemService;

    /**
     * @param iid   产品id
     * @param count 产品数量
     * @return
     */
    @RequestMapping(value = "/addCart")
    public List<CartItem> addCart(@RequestParam("iid") String iid, @RequestParam("count") int count, HttpServletRequest request) {
        //判断用户是否登录
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            //说明用户没有登录,也是允许用户加入购物车的。此时购物车信息存放到session里面
            Map<String, CartItem> myCart = (Map<String, CartItem>) request.getSession().getAttribute(" myCart");
            if (iid != null) {
                //根据iid获取商品
                Item item = itemService.findById(iid);
                if (myCart == null) {
                    //说明是第一次加入购物车
                    myCart = new HashMap<String, CartItem>();
                    CartItem cartItem = new CartItem();
                    cartItem.setCount(count);
                    cartItem.setIid(iid);
                    cartItem.setItem(item);
                    myCart.put(iid, cartItem);
                } else {
                    if (myCart.containsKey(iid)) {
                        //如果购物车存在此商品 则数量增加
                        CartItem cartItem = myCart.get(iid);
                        cartItem.setCount(cartItem.getCount() + count);
                        myCart.put(iid, cartItem);

                    } else {
                        CartItem cartItem = new CartItem();
                        cartItem.setCount(count);
                        cartItem.setIid(iid);
                        cartItem.setItem(item);
                        myCart.put(iid, cartItem);
                    }
                }
            }
            request.getSession().setAttribute("myCart", myCart);
            request.getSession().setMaxInactiveInterval(10 * 60);
        } else {
            Map<String, CartItem> myCart = (Map<String, CartItem>) request.getSession().getAttribute("myCart");
            if (myCart == null) {
                if (iid != null) {
                    //根据产品iid 获得一条购物信息
                    CartItem byIid = cartItemService.findByIid(iid);
                    if (byIid == null) {
                        //如果不存在，则第一次加入此产品 insert
                        CartItem cartItem = new CartItem();
                        cartItem.setId(UUID.randomUUID().toString().replace("-", ""));
                        cartItem.setCount(count);
                        cartItem.setUid(user.getUid());
                        cartItem.setIid(iid);
                        cartItemService.insert(cartItem);
                    } else {
                        byIid.setCount(byIid.getCount() + count);
                        cartItemService.update(byIid);
                    }
                }
            } else {
                //如果车不是空的  遍历session
                Set<String> keys = myCart.keySet();
                Iterator<String> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    //购物车里的
                    CartItem cartItem = myCart.get(iterator.next());
                    //根据用户名和产品id判断产品是否存在  如果存在 更新数量  如果不存在 则插入
                    CartItem byIidAdndUid = cartItemService.findByIidAdndUid(cartItem);
                    if (byIidAdndUid != null) {
                        byIidAdndUid.setCount(byIidAdndUid.getCount() + cartItem.getCount());
                        cartItemService.update(byIidAdndUid);
                    } else {
                        //存
                        cartItem.setId(UUID.randomUUID().toString().replace("-", ""));
                        cartItem.setUid(user.getUid());
                        cartItemService.insert(cartItem);
                    }
                }
                request.getSession().removeAttribute("myCart");
            }
        }
        List<CartItem> cartItems = cartItemService.findAll(user.getUid());
        return cartItems;
    }

}
