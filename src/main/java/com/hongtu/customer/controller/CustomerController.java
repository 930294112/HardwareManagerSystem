package com.hongtu.customer.controller;

import com.hongtu.customer.bean.Customer;
import com.hongtu.customer.service.CustomerService;
import com.hongtu.util.AjaxResult;
import com.hongtu.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;
    private int pageSize =10;
    @RequestMapping(value = "/list")
    public String customer(Integer pageNum,Model model){
        if (pageNum==null){
            pageNum=1;
        }
        PageBean<Customer> pageBean = customerService.findAllCustomer(pageNum, pageSize);
        model.addAttribute("pageBean",pageBean);
        System.out.println(pageBean);
        return "/adminjsps/admin/customer/list";
    }

    @RequestMapping(value = "/add")
    public String add(){
        return "/adminjsps/admin/customer/add";
    }

    @RequestMapping(value = "/addSave")
    @ResponseBody
    public AjaxResult<Customer> addSave(Customer customer){
        AjaxResult<Customer> result = new AjaxResult<Customer>();
        customer.setCuid(UUID.randomUUID().toString().replaceAll("-",""));
        int count = customerService.save(customer);
        result.setCount(count);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/databath")
    public AjaxResult<Customer> databath(@RequestParam(value = "deleteIds[]") String[]  deleteIds ){
        System.out.println(deleteIds);
        AjaxResult<Customer> result = new AjaxResult<Customer>();
        List<Integer> list = customerService.deleteByIds(deleteIds);
        if (list.size() == deleteIds.length){
            result.setCount(1);
        }
        return result;
    }

    @RequestMapping(value = "/query")
    public String query(Customer customer,Integer pageNum,Model model){
        System.out.println(customer);
        if (pageNum==null){
            pageNum=1;
        }
        PageBean<Customer> pageBean = customerService.query(customer, pageNum, pageSize);
        System.out.println(pageBean);
        model.addAttribute("pageBean",pageBean);
        return "/adminjsps/admin/customer/list";

    }
}
