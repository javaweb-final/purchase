package com.javaweb.purchase.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.purchase.entity.Shop;
import com.javaweb.purchase.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService extends ServiceImpl<ShopMapper, Shop> {
    @Autowired
    private ShopMapper shopMapper;
    public List<Shop> findShop(String username,String password){
        return shopMapper.getShop(username,password);
    }
}
