package com.hongtu.user.mapper;

import com.hongtu.user.bean.User;
import com.hongtu.user.bean.ext.ExtUser;
import com.hongtu.util.PageBean;

import java.util.List;

public interface UserMapper {
    List<User> findAllUser();

    int findCount();

    List<User> findAll(PageBean<User> pageBean);

    int deleteById(String deleteId);

    int findCountQueyr(ExtUser extUser);

    List<User> query(PageBean<User> pageBean);

    void addUser(User user);

    User findById(String uid);
}
