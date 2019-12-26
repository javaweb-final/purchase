package com.javaweb.purchase.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.javaweb.purchase.entity.Product;
import com.javaweb.purchase.entity.Shop;
import com.javaweb.purchase.entity.Super;
import com.javaweb.purchase.mapper.ProductMapper;
import com.javaweb.purchase.mapper.ShopMapper;
import com.javaweb.purchase.mapper.SuperMapper;
import com.javaweb.purchase.service.ShopService;
import com.javaweb.purchase.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.javaweb.purchase.utils.SmsSDKDemo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

import static com.javaweb.purchase.utils.SmsSDKDemo.testSms;

@Controller
@RequestMapping("/super")
public class SuperController {
    static String code1;
    @Autowired
    private SuperService superService;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SuperMapper superMapper;
    @RequestMapping("/login")
    public String login(){
        return "Admin_login";
    }

    @ResponseBody
    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)

    public String loginCheck(HttpSession session, HttpServletRequest request){

        String username=request.getParameter("name");
        String pawssword=request.getParameter("pwd");
        String flag=request.getParameter("flag");
        session.setAttribute("username",username);
        List<Super> l=superService.findUser(username,pawssword);

        if (l.size()==0){
            return "100";
        }else{
            if (flag.equals(code1)){
                return "101";
            }else{
                return "100";
            }
        }
    }
    @ResponseBody
    @RequestMapping(value = "/getflag",method = RequestMethod.POST)

    public String getflag(HttpSession session, HttpServletRequest request,Model model){

        String username=request.getParameter("name");

        List<Super> l1=superMapper.findSup(username);

        if (l1.size()==0){
            return "100";
        }else{
            String phone=l1.get(0).getPhone();
            String code = "";
            Random random = new Random();
            for (int i = 0; i < 6; i++) {
                int r = random.nextInt(10); //每次随机出一个数字（0-9）
                code = code + r;  //把每次随机出的数字拼在一起
            }
            System.out.println(code);
            code1=code;
            session.setAttribute("code",code);
            testSms(phone,code);
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
    @RequestMapping("/addsup")
    public String addsho(){
        return "Adminreg";
    }
    @ResponseBody
    @RequestMapping("/addsuper")
    public String addshop(HttpServletRequest request){
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        String phone=request.getParameter("phone");
        Super super1=new Super();
        super1.setPassword(pwd);
        super1.setUsername(name);
        super1.setPhone(phone);
        superService.save(super1);
        return "success";
    }
}
