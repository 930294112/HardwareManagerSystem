package com.hongtu.category.service.impl;

import com.hongtu.category.bean.Category;
import com.hongtu.category.bean.CategoryItem;
import com.hongtu.category.mapper.CategoryMapper;
import com.hongtu.category.mapper.CategoryItemMapper;
import com.hongtu.category.service.CategoryService;
import com.hongtu.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
     private CategoryMapper categoryMapper;
    @Resource
    private CategoryItemMapper categoryItemMapper;

    public List<Category> findAllNoPage() {
        return categoryMapper.findAllNoPage();
    }

    public PageBean<Category> findAllItems(String cid, Integer pageNum, Integer pageSize) {
        int totalCount = categoryItemMapper.findCountByCid(cid);
        PageBean<Category> pageBean = new PageBean<Category>(pageNum,pageSize,totalCount);
        pageBean.setCondition(cid);
        Category category = categoryMapper.findAllItems(pageBean);
        System.out.println(category);
        System.out.println(category.getItems());
        pageBean.setT(category);
        return pageBean;
    }

    public PageBean<Category> queryByName(String cname, Integer pageNum, int pageSize) {
        int totalCount = categoryMapper.findCountByName(cname);
        PageBean<Category> pageBean = new PageBean<Category>(pageNum,pageSize,totalCount);
        pageBean.setCondition(cname);
        List<Category> categories = categoryMapper.queryByName(pageBean);
        System.out.println(categories);
        pageBean.setData(categories);
        return pageBean;
    }


    public int addCategory(Category category) {
        //根据分类的名字查询改分类是否存在
        Category categoryByName = categoryMapper.findByName(category.getCname());
        if (categoryByName != null){
            return 0;
        }else {
            return categoryMapper.addCategory(category);
        }

    }

    public Category findById(String cid) {
        return categoryMapper.findById(cid);
    }

    public int modCategory(Category category) {
      return   categoryMapper.modCategory(category);

    }

    public int delCategory(Category category) {
        //根据要删除的id去查询改分类下是否有商品，如果有不可以删除
        List<CategoryItem> categoryItems = categoryItemMapper.findByCid(category.getCid());
        System.out.println(categoryItems);
        if (categoryItems.size()>0){
            return 0;
        }else {
            return categoryMapper.delCategory(category);
        }

    }

    public PageBean<Category> findAllCategory(Integer pageNum, Integer pageSize) {
        int  totalCount = categoryMapper.findCount();
        PageBean<Category> pageBean = new PageBean<Category>(pageNum,pageSize,totalCount);
        List<Category> accounts = categoryMapper.findAll(pageBean);
        System.out.println(accounts);
        pageBean.setData(accounts);
        return pageBean;
    }



}
