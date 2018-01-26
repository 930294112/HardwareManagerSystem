package com.hongtu.category.mapper;

import com.hongtu.category.bean.Category;
import com.hongtu.util.PageBean;

import java.util.List;

public interface CategoryMapper {
    List<Category> findAll(PageBean<Category> pageBean);

    int addCategory(Category category);

    Category findByName(String cname);

    Category findById(String cid);

    int modCategory(Category category);

    int delCategory(Category category);

    int findCount();

    List<Category> findAllNoPage();

    Category findAllItems(PageBean<Category> pageBean);

    int findCountByName(String cname);

    List<Category> queryByName(PageBean<Category> pageBean);
}
