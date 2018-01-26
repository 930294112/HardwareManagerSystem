package com.hongtu.base.controller;

import com.hongtu.admin.bean.Admin;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @RequestMapping(value = "/login")
    public String home(){
        return "login";
    }


    @RequestMapping(value = "/top")
    public String top(HttpServletRequest request, Model model){
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        System.out.println(admin);
        model.addAttribute("admin",admin);
        return "adminjsps/admin/top";
    }

    @RequestMapping(value = "/left")
    public String left(HttpServletRequest request, Model model){
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        System.out.println(admin);
        model.addAttribute("admin",admin);
        return "adminjsps/admin/left";
    }

    @RequestMapping(value = "/body")
    public String body(){
        return "adminjsps/admin/body";
    }

    @RequestMapping(value = "/loginout")
    public String loginout(){
        return "redirect:/login";
    }

}
