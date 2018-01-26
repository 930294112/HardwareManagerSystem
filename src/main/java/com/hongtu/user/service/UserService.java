package com.hongtu.user.service;

import com.github.pagehelper.Page;
import com.hongtu.user.bean.User;
import com.hongtu.user.bean.ext.ExtUser;
import com.hongtu.util.PageBean;

import java.util.List;

public interface UserService {
    PageBean<User> findAllUser(Integer pageNum, int pageSize);

    List<Integer> deleteByIds(String[] deleteIds);

    PageBean<User> query(ExtUser extUser, Integer pageNum, int pageSize);

    void addUser(User user);
}
