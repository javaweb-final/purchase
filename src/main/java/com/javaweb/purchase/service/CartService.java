package com.javaweb.purchase.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.purchase.entity.Cart;
import com.javaweb.purchase.entity.CartVo;
import com.javaweb.purchase.entity.UserCartVo;
import com.javaweb.purchase.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CartService extends ServiceImpl<CartMapper, Cart> {
    @Autowired
    private CartMapper cartMapper;

    /**
     * 根据用户查询购物车
     */

    public List<CartVo> findCartByUser(Integer userId) {
        return cartMapper.findCartListByUserId(userId);
    }
    /**
     * 根据购物车id查询对应的纪录
     */
    public List<CartVo> findCartByIds(String ids){

        String id[]=ids.split(",");
        Integer in[]=new Integer[id.length];
        for (int i=0;i<id.length;i++){
            in[i]=Integer.valueOf(id[i]);
        }
        List<Integer> list=new ArrayList<>();
        for (Integer i:in){
            list.add(i);
        }
//        return cartMapper.findCartListByIds(Arrays.asList(ids));
        return cartMapper.findCartListByIds(list);

    }
    /**
     * 统计购物车总价
     */
    public double getCartItemTotal(List<CartVo> list){
        double sum=0.0;
        for (CartVo cart:list){
            sum+=cart.getCount()*cart.getNewPrice();
        }
        return sum;
    }
    /**
     *
     * 批量删除
     */
    public String batchDelete(String ids){
        if (ids!=null){
            String [] idArray=ids.split(",");
            cartMapper.deleteBatchIds(Arrays.asList(idArray));
        }
        return "success";
    }

    /**
     * 包装购物车数据
     */
    public UserCartVo wrapperCart(List<CartVo> list){
        UserCartVo userCartVo=new UserCartVo();
        userCartVo.setNum(list.size());
        userCartVo.setTotalPrice(getCartItemTotal(list));
        return userCartVo;
    }
}
