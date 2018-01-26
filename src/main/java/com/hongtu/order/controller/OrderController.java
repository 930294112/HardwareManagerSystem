package com.hongtu.order.controller;

import com.hongtu.customer.bean.Customer;
import com.hongtu.customer.service.CustomerService;
import com.hongtu.order.bean.Order;
import com.hongtu.order.service.OrderService;
import com.hongtu.util.AjaxResult;
import com.hongtu.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private CustomerService customerService;
    private int pageSize=5;

    /**
     * 查看所有订单
     * @param state 订单的状态
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(@RequestParam("state")String state, Integer pageNum, Model model){
        if (pageNum==null){
            pageNum=1;
        }
        PageBean<Order> pageBean =orderService.findAllOrder(state,pageNum,pageSize);
        model.addAttribute("pageBean",pageBean);
        List<Customer> customers = customerService.findAllCustomerNoPage();
        model.addAttribute("customers",customers);
        return "adminjsps/admin/order/list";
}

    /**
     * 卖家发货 更改订单的状态
     * @param oid 要发货订单的oid
     * @return
     */
    @RequestMapping(value = "/updateState")
    @ResponseBody
    public AjaxResult<Order> updateState(@RequestParam("oid")String oid){
        System.out.println(oid);
        AjaxResult<Order> result = new AjaxResult<Order>();
        int count = orderService.updateState(oid);
        result.setCount(count);
        return result;
}

    /**
     * 某个顾客下的所有的订单
     * @param uid 顾客的id
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping(value = "/userlist")
    public String userlist(@RequestParam("uid")String uid, Integer pageNum,Model model){
        if (pageNum==null){
            pageNum=1;
        }
        PageBean<Order> pageBean = orderService.findOrderByUid(uid,pageNum,pageSize);
        model.addAttribute("pageBean",pageBean);
        return "adminjsps/admin/order/userlist";
    }

    @RequestMapping(value = "/customer")
    public String customer(@RequestParam("cuid")String cuid, Integer pageNum,Model model){
        if (pageNum==null){
            pageNum=1;
        }
        PageBean<Order> pageBean = orderService.findOrderByCuid(cuid,pageNum,pageSize);
        model.addAttribute("pageBean",pageBean);
        return "adminjsps/admin/order/customer";
    }

    /**
     * 增加订单
     * @return
     */
    @RequestMapping(value = "/addOrder")
    public String addOrder(){

        return "";
    }

    /**
     * 打印某个订单
     * @param oid
     * @param model
     * @return
     */
    @RequestMapping(value = "/print")
    public String print(@RequestParam("oid") String oid,Model model){
        Order order = orderService.findOrderById(oid);
        model.addAttribute("order",order);
        return "adminjsps/admin/order/print";
    }

    @RequestMapping(value = "/addCustomer")
    public String addCustomer(@RequestParam("oid") String oid,Order order){
        order.setOid(oid);
        int count = orderService.addCustomer(order);
        return "redirect:/order/list?state="+"0";

    }




}
