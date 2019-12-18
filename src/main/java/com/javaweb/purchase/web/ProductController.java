package com.javaweb.purchase.web;

import com.javaweb.purchase.entity.Evaluate;
import com.javaweb.purchase.entity.Product;
import com.javaweb.purchase.entity.User;
import com.javaweb.purchase.service.EvaluateService;
import com.javaweb.purchase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/prod")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private EvaluateService evaluateService;
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    /**
     * 获取图书信息
     */
    @RequestMapping("/getProductData")
    public String getProductData(Model model,Integer page,Integer category){
        //mybatis plus分页
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category",category);
        IPage<Product> iPage = productService.page(new Page<>(page,4),queryWrapper);
        model.addAttribute("productList",iPage.getRecords());
        model.addAttribute("pre",iPage.getCurrent() - 1);
        model.addAttribute("next",iPage.getCurrent() + 1);
        model.addAttribute("cur",iPage.getCurrent());
        model.addAttribute("last",iPage.getPages());
        model.addAttribute("category",category);
        return "productData";
    }
    /**
     * 图书列表页
     */
    @RequestMapping("/productList")
    public String productList(String category, Model model){
        model.addAttribute("category",category);
        return "products_list";
    }

    /**
     * 获取图书列表数据
     */
    @RequestMapping("/getProductListData")
    public String getProductListData(String category,Integer page, Integer pageSize, Model model){
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category",category);
        IPage<Product> iPage = productService.page(new Page<Product>(page,pageSize),queryWrapper);
        model.addAttribute("productList",iPage.getRecords());
        model.addAttribute("pre",iPage.getCurrent() - 1);
        model.addAttribute("next",iPage.getCurrent() + 1);
        model.addAttribute("cur",iPage.getCurrent());
        model.addAttribute("pages",iPage.getPages());
        model.addAttribute("category",category);
        model.addAttribute("pageSize",pageSize);
        return "productsListData";
    }

    /**
     * 详情
     */
    @RequestMapping("/detail")
    public String detail(Integer id,Model model){
        Product product = productService.getById(id);
        //add
        QueryWrapper<Evaluate> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("thing_id",id);

        IPage<Evaluate> iPage=evaluateService.page(new Page<>(1,4),queryWrapper);
        model.addAttribute("evaluateList",iPage.getRecords());
        model.addAttribute("product",product);

        return "details";
    }
//    @RequestMapping("/getEvaluateData")
//    public String getEvaluateData(Integer id,Model model){
//        QueryWrapper<Evaluate> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq("thing_id",id);
//        IPage<Evaluate> iPage=evaluateService.page(new Page<>(1,4),queryWrapper);
//        model.addAttribute("evaluateList",iPage.getRecords());
//        return "evaluateData";
//    }
}
