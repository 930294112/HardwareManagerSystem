package com.hongtu.item.service;


import com.hongtu.category.bean.Category;
import com.hongtu.item.bean.Item;
import com.hongtu.util.PageBean;

import java.util.List;

public interface ItemService {


   Item findById(String iid);

    int delItem(String iid);

    int modItem(Item item);

    int addItem(Item item);

    PageBean<Item> findAllItem(String sort,String column,Integer pageNum, int pageSize);

    PageBean<Category> queryByName(String iname, Integer pageNum, int pageSize);

}
