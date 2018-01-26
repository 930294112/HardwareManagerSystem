package com.hongtu.item.controller;

import com.hongtu.item.bean.Item;
import com.hongtu.item.service.ItemService;
import com.hongtu.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/stock_sales")
public class StockSalesController {

    @Resource
    private ItemService itemService;
    private int pageSize = 10;

    @RequestMapping(value = "/list")
    public String list(String sort, String column, Integer pageNum, Model model) {

        if (pageNum == null) {
            pageNum = 1;
        }
        if (sort != null && column != null) {
            if (column.contains("stock")) {
                if (sort.contains("desc")) {
                    model.addAttribute("stock_sort", sort);
                    sort = "DESC";
                } else if (sort.contains("asc")) {
                    model.addAttribute("stock_sort", sort);
                    sort = "ASC";
                }
            } else if (column.contains("sales")) {
                if (sort.contains("desc")) {
                    model.addAttribute("sales_sort", sort);
                    sort = "DESC";
                } else if (sort.contains("asc")) {
                    model.addAttribute("sales_sort", sort);
                    sort = "ASC";
                }
            }

        }
        PageBean<Item> pageBean = itemService.findAllItem(sort, column, pageNum, pageSize);
        model.addAttribute("pageBean", pageBean);
        return "adminjsps/admin/stock_sales/list";
    }
}
