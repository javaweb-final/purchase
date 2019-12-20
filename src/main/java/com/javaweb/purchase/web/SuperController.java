package com.javaweb.purchase.web;

import com.javaweb.purchase.entity.Product;
import com.javaweb.purchase.entity.Shop;
import com.javaweb.purchase.entity.Super;
import com.javaweb.purchase.mapper.ProductMapper;
import com.javaweb.purchase.mapper.ShopMapper;
import com.javaweb.purchase.service.ShopService;
import com.javaweb.purchase.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/super")
public class SuperController {

    @Autowired
    private SuperService superService;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ProductMapper productMapper;
    @RequestMapping("/login")
    public String login(){
        return "Admin_login";
    }

    @ResponseBody
    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)

    public String loginCheck(HttpSession session, HttpServletRequest request){

        String username=request.getParameter("name");
        String pawssword=request.getParameter("pwd");
        session.setAttribute("username",username);
        List<Super> l=superService.findUser(username,pawssword);

        if (l.size()==0){
            return "100";
        }else{
            return "101";
        }
    }

    @RequestMapping("/shop")
    public String shop(Model model){
        List<Shop> l=superService.findShop();
        model.addAttribute("shops",l);
        return "Admin_shop";
    }

    @RequestMapping(value = "/product")
    public String product(Model model){
        List<Product> l=superService.findPeoduct();
        model.addAttribute("products",l);
        return "Admin_product";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(HttpServletRequest request){
        Integer id=Integer.valueOf(request.getParameter("Id"));
        shopMapper.deleteById(id);
        return "Admin_shop";
    }
    @RequestMapping(value = "/deletepro",method = RequestMethod.POST)
    public String deletepro(HttpServletRequest request){
        Integer id=Integer.valueOf(request.getParameter("Id"));
        productMapper.deleteById(id);
        return "Admin_product";
    }
}
