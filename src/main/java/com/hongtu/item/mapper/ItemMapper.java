package com.hongtu.item.mapper;

import com.hongtu.category.bean.Category;
import com.hongtu.item.bean.Item;
import com.hongtu.util.PageBean;

import java.util.List;

public interface ItemMapper {

    Item findById(String iid);

    int delItem(String iid);

    int modItem(Item item);

    int addItem(Item item);

    int findCount();

    List<Item> findAll(PageBean<Item> pageBean);

    int findCountByName(String iname);

    List<Category> queryByName(PageBean<Category> pageBean);
}
