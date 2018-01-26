package com.hongtu.user.controller;

import com.hongtu.user.bean.User;
import com.hongtu.user.bean.ext.ExtUser;

import com.hongtu.user.service.UserService;
import com.hongtu.util.AjaxResult;
import com.hongtu.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;
    private int pageSize=10;

    /**
     * 分业查询所有的用户
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(Integer pageNum, Model model){
        if (pageNum==null){
            pageNum=1;
        }
        PageBean<User> pageBean = userService.findAllUser(pageNum,pageSize);
        model.addAttribute("pageBean",pageBean);
        return "adminjsps/admin/user/list";
    }

    /**
     * 批量删除
     * @param deleteIds
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/databath")
    public AjaxResult<User> databath(@RequestParam(value = "deleteIds[]") String[]  deleteIds ){
        System.out.println(deleteIds);
        AjaxResult<User> result = new AjaxResult<User>();
        List<Integer> list = userService.deleteByIds(deleteIds);
        if (list.size() == deleteIds.length){
            result.setCount(1);
        }
        return result;
    }

    /**
     * 分页和高级查询
     * @param extUser
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping(value = "/query")
    public String query(ExtUser extUser,Integer pageNum,Model model){
        System.out.println(extUser);
        if (pageNum==null){
            pageNum=1;
        }
        PageBean<User> pageBean = userService.query(extUser, pageNum, pageSize);
        System.out.println(pageBean);
        model.addAttribute("pageBean",pageBean);
        return "adminjsps/admin/user/list";
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser")
     public String addUser(User user){
        user.setCreate_time(new Timestamp(System.currentTimeMillis()));
        userService.addUser(user);
        return "";
     }
}
