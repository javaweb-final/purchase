package com.javaweb.purchase.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.purchase.entity.CartVo;
import com.javaweb.purchase.entity.User;
import com.javaweb.purchase.entity.UserCartVo;
import com.javaweb.purchase.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;


@Service
@SessionAttributes("user")
public class UserService extends ServiceImpl<UserMapper,User> {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CartService cartService;

    /**
     * 验证用户的存在性
     */
    public String checkUser(String username){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = userMapper.selectOne(queryWrapper);
        if(user == null){
            return "101";//用户不存在
        } else {
            return "102";//用户已存在
        }
    }

    /**
     * 登录验证
     */
    public String loginCheck(User loginUser,HttpSession session){
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().eq(User::getUsername,loginUser.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        if(user == null){
            return "101";//用户不存在
        } else {
            //判断密码
            if(loginUser.getPassword().equals(user.getPassword())){
                session.setAttribute("user",user);

                List<CartVo> cartVos = cartService.findCartByUser(user.getId());
                UserCartVo userCartVo = cartService.wrapperCart(cartVos);
                session.setAttribute("userCartInfo",userCartVo);

                return "100";
            } else {
                return "102";//密码不正确
            }
        }
    }
}
