package com.hongtu.item.controller;
import com.hongtu.category.bean.Category;
import com.hongtu.category.service.CategoryService;
import com.hongtu.item.bean.Item;
import com.hongtu.item.service.ItemService;
import com.hongtu.util.AjaxResult;
import com.hongtu.util.PageBean;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/item")
public class ItemComtroller {

    @Resource
    private ItemService itemService;
    @Resource
    private CategoryService categoryService;
    private int pageSize =10;
    @RequestMapping(value = "/list")
    public String list(String sort,String colunm,Integer pageNum,Model model){
        System.out.println(sort);
        if (pageNum==null){
            pageNum=1;
        }
        PageBean<Item> pageBean = itemService.findAllItem(sort,colunm,pageNum,pageSize);
        model.addAttribute("pageBean",pageBean);
        return "adminjsps/admin/item/list";
    }

    @RequestMapping(value = "/add")
    public String add(Model model){
        List<Category> categories = categoryService.findAllNoPage();
        model.addAttribute("categories",categories);
        return "adminjsps/admin/item/add";
    }

    @RequestMapping(value = "/desc")
    public String desc(String iid, Model model){
        Item item = itemService.findById(iid);
        model.addAttribute("item",item);
        Category category = categoryService.findById(item.getCid());
        item.setCname(category.getCname());
        List<Category> categories = categoryService.findAllNoPage();
        model.addAttribute("categories",categories);
        return "adminjsps/admin/item/desc";
    }

    /**
     * 删除商品
     * @param iid 要删除商品的id
     * @return
     */
    @RequestMapping(value = "/delItem")
    @ResponseBody
    public AjaxResult<Item> delItem(String iid){
        System.out.println(iid);
        AjaxResult result = new AjaxResult();
        int count = itemService.delItem(iid);
        result.setCount(count);
        return result;
    }

    /**
     * 修改商品
     * @param item 修改商品的信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/modItem")
    public AjaxResult<Item> modItem(Item item){
        AjaxResult<Item> result = new AjaxResult<Item>();
        System.out.println(item);
        int count = itemService.modItem(item);
        result.setCount(count);
        return result;
    }

    /**
     * 添加商品
     * @param item  添加的商品
     * @param file 添加商品的图片
     * @param request
     * @return
     */
    @RequestMapping(value = "/addItem")
    public String addItem(Item item, @RequestParam(value = "file") MultipartFile file,HttpServletRequest request){
        System.out.println(item);
        System.out.println(file);
        String type = null;
        if (file!=null){
            String fileName = file.getOriginalFilename();
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type!=null){
                if (("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase()))){
                    String realPath = request.getSession().getServletContext().getRealPath("/temp");
                    File newPath = new File(realPath);
                    if (!newPath.exists()){
                        newPath.mkdirs();
                    }
                    System.out.println(newPath);
                    String trueFileName = String.valueOf(System.currentTimeMillis() + fileName);
                    File desPath = new File(newPath,trueFileName);
                    try {
                        FileUtils.writeByteArrayToFile(desPath,file.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    item.setImage("/temp/" + trueFileName);
                }
            }
        }
        System.out.println(item);
        item.setIid(UUID.randomUUID().toString().replaceAll("-",""));
        int count = itemService.addItem(item);
        System.out.println(count);
        return "redirect:/item/list";
    }

    /**
     * 高级查询  根据商品名字进行模糊查询
     * @param iname
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryByName")
    public String queryByName(String iname, Integer pageNum, Model model){
        System.out.println(iname);
        if (pageNum==null){
            pageNum=1;
        }
        PageBean<Category> pageBean = itemService.queryByName(iname, pageNum, pageSize);
        model.addAttribute("pageBean",pageBean);
        System.out.println(pageBean);
        return "adminjsps/admin/category/desItem";
    }
}
