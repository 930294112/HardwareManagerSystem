package com.hongtu.category.controller;
import com.hongtu.category.bean.Category;
import com.hongtu.category.service.CategoryService;
import com.hongtu.item.bean.Item;
import com.hongtu.util.AjaxResult;
import com.hongtu.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    private int pageSize =10;


    //分页查询所有
    @RequestMapping("/list")
    public String list(Integer pageNum, Model model){
        if (pageNum==null){
            pageNum=1;
        }

       PageBean<Category> pageBean = categoryService.findAllCategory(pageNum, pageSize);
        model.addAttribute("pageBean",pageBean);
        System.out.println(pageBean);
        return "adminjsps/admin/category/list";

    }

    /**
     * 高级查询  根据分类的名称
     * @param cname 查询的分类的名称
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping("queryByName")
    public String queryByName(String cname,Integer pageNum,Model model){
        System.out.println(cname);
        if (pageNum==null){
            pageNum=1;
        }
        PageBean<Category> pageBean = categoryService.queryByName(cname, pageNum, pageSize);
        model.addAttribute("pageBean",pageBean);
        System.out.println(pageBean);
        return "adminjsps/admin/category/list";
    }





   //跳转到添加分类的界面
    @RequestMapping(value = "/add")
    public String add(){
        return "adminjsps/admin/category/add";
    }

    //添加分类
    @RequestMapping(value = "/addCategory")
    @ResponseBody
    public AjaxResult<Category> addCategory(Category category){
        AjaxResult<Category> result = new AjaxResult<Category>();
        //给分类一个uuid
        category.setCid(UUID.randomUUID().toString().replaceAll("-",""));
        int count = categoryService.addCategory(category);
        System.out.println(count);
        result.setCount(count);
        return result;
    }


    //跳转到修改的页面并表单回显
    @RequestMapping(value = "/mod")
    public String mod(String cid,Model model){
        Category category = categoryService.findById(cid);
        model.addAttribute("category",category);
        return "adminjsps/admin/category/mod";
    }

    //保存修改的内容
    @RequestMapping(value = "/modCategory")
    @ResponseBody
    public AjaxResult<Category> modCategory(Category category){
        AjaxResult<Category> result = new AjaxResult<Category>();
        int count = categoryService.modCategory(category);
        result.setCount(count);
        return  result;
    }

    /**
     * 跳转到删除的页面
     * @param cid 根据id找到要删除的分类
     * @param model
     * @return
     */
    @RequestMapping(value = "/del")
    public String del(String cid,Model model){
        Category category = categoryService.findById(cid);
        model.addAttribute("category",category);
        return "adminjsps/admin/category/del";
    }

    /**
     * 根据id进行删除
     * @param category
     * @return
     */
    @RequestMapping(value = "/delCategory")
    @ResponseBody
    public AjaxResult<Category> delCategory(Category category){
        AjaxResult<Category> result = new AjaxResult<Category>();
        int count = categoryService.delCategory(category);
        result.setCount(count);
        return  result;
    }

    /**
     * 查询某个类别下的所有商品
     * @param cid
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping(value = "/query")
    public String query(String cid,Integer pageNum,Model model){
        if (pageNum==null){
            pageNum=1;
        }
        PageBean<Category> pageBean = categoryService.findAllItems(cid, pageNum, pageSize);
        List list = new ArrayList();
        for (Item item : pageBean.getT().getItems()) {
            if (item.getIid()!=null){
                list.add(item.getIid());
            }
        }

        if (list.size()==0){
            model.addAttribute("msg","改分类下没有商品");
            return "adminjsps/admin/category/desItem";
        }else {
            model.addAttribute("pageBean",pageBean);
            return "adminjsps/admin/category/desItem";
        }

    }


}
