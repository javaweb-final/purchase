package com.javaweb.purchase.web;

import com.javaweb.purchase.entity.User;
import com.javaweb.purchase.entity.UserCartVo;
import com.javaweb.purchase.service.CartService;
import com.javaweb.purchase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Auther: jzhang
 * @Date: 2019/9/24 15:49
 * @Description: 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    //验证用户名是否存在
    @ResponseBody
    @RequestMapping("/checkUserName")
    public String checkUserName(String username){
        return userService.checkUser(username);
    }

    /**
     * 用户注册
     */
    @ResponseBody
    @RequestMapping("register")
    public String register(User user){
        userService.save(user);
        return "success";
    }

    /**
     * 用户登录
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(User user,HttpSession session){
        return userService.loginCheck(user,session);
    }

    /**
     * 安全退出
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/prod/index";
    }
}