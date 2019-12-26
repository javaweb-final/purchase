package com.javaweb.purchase.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.purchase.entity.Product;
import com.javaweb.purchase.entity.Shop;
import com.javaweb.purchase.entity.Super;
import com.javaweb.purchase.mapper.SuperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

import static com.javaweb.purchase.utils.SmsSDKDemo.testSms;

@Service
public class SuperService extends ServiceImpl<SuperMapper, Super> {
    @Autowired
    private SuperMapper superMapper;
    public List<Super> findUser(String username,String password){
        return superMapper.findSuper(username,password);
    }
    public List<Shop> findShop(){
        return  superMapper.findUser();
    }
    public List<Product> findPeoduct(){
        return superMapper.findProduct();
    }


}
