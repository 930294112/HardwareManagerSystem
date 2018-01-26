package com.hongtu.cart.controller;
import com.hongtu.cart.bean.Cart;
import com.hongtu.cart.bean.CartItem;
import com.hongtu.cart.service.CartService;
import com.hongtu.item.bean.Item;
import com.hongtu.item.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import java.util.Map;

@Controller
public class CartController {
    @Resource
    private CartService cartService;
    @Resource
    private ItemService itemService;

    @RequestMapping(value = "/addCart")
    public String addCart(@RequestParam("iid") String iid,@RequestParam("count") int count){
        Cart cart = new Cart();
        Map<String,CartItem> cartItemMap = cart.getCartItemMap();
        //根据iid找到商品
        Item item = itemService.findById(iid);
        //使用item,count 创建CartItem
        CartItem cartItem = new CartItem(count,item);
        //将cartItem放入cartItemMap中
        cartItemMap.put(iid,cartItem);
        return "";
    }
}
