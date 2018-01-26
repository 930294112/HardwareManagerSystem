package com.hongtu.item.service.impl;
import com.hongtu.category.bean.Category;
import com.hongtu.category.bean.CategoryItem;
import com.hongtu.category.mapper.CategoryItemMapper;
import com.hongtu.item.bean.Item;
import com.hongtu.item.mapper.ItemMapper;
import com.hongtu.item.service.ItemService;
import com.hongtu.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemMapper itemMapper;
    @Resource
    private CategoryItemMapper categoryItemMapper;

    public Item findById(String iid) {
        return itemMapper.findById(iid);
    }

    public int delItem(String iid) {
        int count1 = categoryItemMapper.del(iid);
        int count2 = itemMapper.delItem(iid);
        if (count1>0 && count2 >0){
            return count2;
        }else {
            return 0;
        }
    }

    public int modItem(Item item) {
        CategoryItem categoryItem = new CategoryItem(item.getCid(),item.getIid());
        int count1 = categoryItemMapper.mod(categoryItem);
        int count2 = itemMapper.modItem(item);
        if (count1>0 && count2 >0){
            return count2;
        }else {
            return 0;
        }
    }

    public int addItem(Item item) {
        CategoryItem categoryItem = new CategoryItem(item.getCid(),item.getIid());
        int count1 = categoryItemMapper.add(categoryItem);
        int count2 = itemMapper.addItem(item);
        if (count1>0 && count2 >0){
            return count2;
        }else {
            return 0;
        }
    }

    public PageBean<Item> findAllItem(String sort,String column,Integer pageNum, int pageSize) {
        int totalCount= itemMapper.findCount();
        PageBean<Item> pageBean = new PageBean<Item>(pageNum,pageSize,totalCount,sort,column);
        List<Item> items = itemMapper.findAll(pageBean);
        pageBean.setData(items);
        return pageBean;

    }

    public PageBean<Category> queryByName(String iname, Integer pageNum, int pageSize) {
        int totalCount = itemMapper.findCountByName(iname);
        PageBean<Category> pageBean = new PageBean<Category>(pageNum,pageSize,totalCount);
        pageBean.setCondition(iname);
        List<Category> categories = itemMapper.queryByName(pageBean);
        System.out.println(categories);
        pageBean.setData(categories);
        return pageBean;
    }
}
