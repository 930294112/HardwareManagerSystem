package com.hongtu.admin.service.impl;

import com.hongtu.admin.bean.Admin;
import com.hongtu.admin.mapper.AdminMapper;
import com.hongtu.admin.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    public Admin findByAdmin(Admin admin) {
        return adminMapper.findByAdmin(admin);
    }

    public Admin findAdminById(String aid) {
        return adminMapper.findAdminById(aid);
    }

    public int update(Admin admin) {
        return adminMapper.update(admin);
    }
}
