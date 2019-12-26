package com.javaweb.purchase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaweb.purchase.entity.Product;
import com.javaweb.purchase.entity.Shop;
import com.javaweb.purchase.entity.Super;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperMapper extends BaseMapper<Super> {
    @Select("SELECT * FROM `superadmin` WHERE username=#{username} and `password`=#{password}")
    List<Super> findSuper(String username,String password);
    @Select("SELECT * FROM `superadmin` WHERE username=#{username}")
    List<Super> findSup(String username);
    @Select("SELECT * FROM boss ")
    List<Shop> findUser();
    @Select("SELECT * from thing")
    List<Product> findProduct();

}
