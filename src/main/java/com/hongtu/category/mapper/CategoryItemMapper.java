package com.hongtu.category.mapper;

import com.hongtu.category.bean.CategoryItem;

import java.util.List;

public interface CategoryItemMapper {
    List<CategoryItem> findByCid(String cid);

    int add(CategoryItem categoryItem);


    int mod(CategoryItem categoryItem);

    int del(String iid);

    int findCountByCid(String cid);
}
