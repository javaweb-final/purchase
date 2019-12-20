package com.javaweb.purchase.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.javaweb.purchase.entity.Product;
import com.javaweb.purchase.entity.Shop;
import com.javaweb.purchase.entity.enums.Category;
import com.javaweb.purchase.service.ProductService;
import com.javaweb.purchase.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ProductService productService;
    @RequestMapping("/login")
    public String login(){
        return "shop_login";
    }


    @ResponseBody
    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)

    public String loginCheck(HttpSession session, HttpServletRequest request){

        String username=request.getParameter("name");
        String pawssword=request.getParameter("pwd");
        session.setAttribute("username",username);

        List<Shop> l=shopService.findShop(username,pawssword);
        if (l.size()==0){
            return "100";
        }else{
            return "101";
        }
    }


    @RequestMapping(value = "/detail")
    public String detail(HttpSession session, Model model){
        String username=(String) (session.getAttribute("username"));
        QueryWrapper<Shop> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("username",username);
        Shop shop=shopService.getOne(queryWrapper1);
        QueryWrapper<Product> queryWrapper=new QueryWrapper<>();
        int id=shop.getId();
        queryWrapper.eq("boss_id",id);
        List<Product> list=productService.list(queryWrapper);
        model.addAttribute("thingList",list);
        return "shop_detail";
    }

    @RequestMapping("/add")
    public String add(){
        return "shop_add";
    }
    @RequestMapping("/uploadHead")//路径
    @ResponseBody//将返回值处理为json
//注意方法传的参数名字一定要与前台对应不然会报空值
    public String UserUploadHead(MultipartFile headimg, HttpServletRequest request,HttpSession session) throws IOException {
//        文件上传
//        1.得到文件名字
//        2.给文件重命名
//        3.指定保存路径
//        4.上传

        String fileName = headimg.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String newFileName = uuid + fileName;
        String path = request.getServletContext().getRealPath("/fly-3.0/res/images/avatar");
        File file1 = new File(path);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        if (!fileName.endsWith(".jpg") && !fileName.endsWith(".png") && !fileName.endsWith(".gif") && !fileName.endsWith(".JPG") && !fileName.endsWith(".PNG") && !fileName.endsWith(".GIF")) {
            return "1";
        }
        // 把文件写到指定路径
        String savePath = path + File.separator + newFileName;
//        String savePath="C:\\Users\\lenovo\\Desktop\\images";
        File finalPach = new File(savePath);
        headimg.transferTo(finalPach);

        String newrod="C:\\Users\\lenovo\\Desktop\\images\\"+newFileName;
        File o=new File(newrod);
        finalPach.renameTo(o);
        session.setAttribute("filename",newFileName);
        System.out.println(finalPach);
        System.out.println(o);
        // 2.修改数据库xxxxxxx.jpg
//        Userinfo log_userinfo = (Userinfo) request.getSession().getAttribute("log_userinfo");
//        log_userinfo.setHeadurl(newFileName);
//        System.out.println(newFileName+","+log_userinfo.getUid());
//        userinfoService.uploadHeadImg(log_userinfo);
        return newFileName;
    }

    @RequestMapping("/addthing")
    public String addthing(HttpSession session,HttpServletRequest request){
        String username=(String) session.getAttribute("username");
        QueryWrapper<Shop> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("username",username);
        Shop shop=shopService.getOne(queryWrapper1);
        int boosId=shop.getId();
        String name=request.getParameter("name");
        int oldPrice=Integer.parseInt(request.getParameter("oldprice"));
        int newPrice=Integer.parseInt(request.getParameter("newprice"));
        String info=request.getParameter("info");
        String imgurl=(String)session.getAttribute("filename");
        int category=Integer.parseInt(request.getParameter("category"));
        Product p=new Product();
        p.setBossId(boosId);
        p.setCategory(Category.getEnumByType(category));
        p.setImgUrl(imgurl);
        p.setInfo(info);
        p.setName(name);
        p.setNewPrice(newPrice);
        p.setOldPrice(oldPrice);
        productService.save(p);
        return "shop_detail";

    }
}
