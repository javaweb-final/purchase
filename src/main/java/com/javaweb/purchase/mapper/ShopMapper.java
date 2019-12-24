package com.javaweb.purchase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaweb.purchase.entity.Shop;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShopMapper extends BaseMapper<Shop> {

    @Select("SELECT * from boss where username=#{username} and password=#{password}")
    List<Shop> getShop(String username,String password);
}
