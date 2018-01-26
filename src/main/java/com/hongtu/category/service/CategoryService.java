package com.hongtu.category.service;

import com.github.pagehelper.PageInfo;
import com.hongtu.category.bean.Category;
import com.hongtu.util.PageBean;

import java.util.List;

public interface CategoryService {


    int addCategory(Category category);

    Category findById(String cid);

    int modCategory(Category category);

    int delCategory(Category category);

    PageBean<Category> findAllCategory(Integer pageNum, Integer pageSize);

    List<Category> findAllNoPage();


    PageBean<Category> findAllItems(String cid,Integer pageNum,Integer pageSize);


    PageBean<Category> queryByName(String cname, Integer pageNum, int pageSize);
}
