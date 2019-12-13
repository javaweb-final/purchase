package com.javaweb.purchase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaweb.purchase.entity.Cart;
import com.javaweb.purchase.entity.CartVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMapper extends BaseMapper<Cart> {
    //查询购物车
    @Select("SELECT\n"+
            "\t c.*,p.NAME AS thingName,p.img_url AS img_url,\n"+
            "\tp.new_price AS new_price\n"+
            "FROM\n"+
            "\tcart c\n"+
            "LEFT JOIN thing p ON c.thing_id = p.id\n"+
            "WHERE\n"+
            "\tc.user_id=#{userId}")
    List<CartVo> findCartListByUserId(Integer userId);

    @Select({
            "<script>" +
                    "SELECT\n" +
                    "\tc.*, p.NAME AS productName, p.img_url AS img_url,\n" +
                    "\tp.new_price AS new_price\n" +
                    "FROM\n" +
                    "\tcart c\n" +
                    "LEFT JOIN thing p ON c.thing_id = p.id\n" +
                    "WHERE c.id in\n" +
                    "<foreach item='item' collection='ids' open='(' separator=',' close=')' >" +
                    "#{item}" +
                    "</foreach>" +
                    "</script>"
    })
    List<CartVo> findCartListByIds(@Param("ids") List<String> ids);
}
