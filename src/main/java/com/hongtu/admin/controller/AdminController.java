package com.hongtu.admin.controller;

import com.hongtu.admin.bean.Admin;
import com.hongtu.admin.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    /**
     * 管理员登录
     * @param admin
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginSubmit")
    public String loginSubmit(Admin admin, Model model, HttpServletRequest request) {
        System.out.println(admin);
        Admin byAdmin = adminService.findByAdmin(admin);
        if (byAdmin != null) {
            request.getSession().setAttribute("admin", byAdmin);
            return "adminjsps/admin/main";
        } else {
            model.addAttribute("message", "用户名或密码错误，请重新输入");
            return "redirect:/login";
        }
    }


    @RequestMapping(value = "/modpassword")
    public String modpassword(@RequestParam("aid") String aid) {
        return "/adminjsps/admin/ad/modpaw";
    }

    /**
     * 修改登录密码
     * @param admin
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/savepwd")
    public String savepwd(Admin admin, HttpServletRequest request, Model model) {
        Admin admin1 = (Admin) request.getSession().getAttribute("admin");
        if (!admin.getApwd().equals(admin1.getApwd())) {
            model.addAttribute("message", "原始密码不正确");
            return "/adminjsps/admin/ad/modpaw";
        } else if (admin.getNewpwd().equals(admin1.getApwd())) {
            model.addAttribute("message", "新密码与原始密码相同");
            return "/adminjsps/admin/ad/modpaw";
        } else if (!admin.getNewpwd().equals(admin.getRepwd())) {
            model.addAttribute("message", "两次密码不一致");
            return "/adminjsps/admin/ad/modpaw";
        } else {
            admin.setAid(admin1.getAid());
            int count = adminService.update(admin);
            if (count > 0) {
                return "/login";
            } else {
                return "/adminjsps/admin/ad/modpaw";
            }
        }

    }


}
