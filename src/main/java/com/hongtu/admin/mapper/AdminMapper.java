package com.hongtu.admin.mapper;

import com.hongtu.admin.bean.Admin;

public interface AdminMapper {
    Admin findAdminByName(String username);

    Admin findByAdmin(Admin admin);

    Admin findAdminById(String aid);

    int update(Admin admin);
}
