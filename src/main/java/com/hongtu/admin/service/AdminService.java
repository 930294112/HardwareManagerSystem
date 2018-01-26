package com.hongtu.admin.service;

import com.hongtu.admin.bean.Admin;

public interface AdminService {
    Admin findByAdmin(Admin admin);

    Admin findAdminById(String aid);

    int update(Admin admin);
}
