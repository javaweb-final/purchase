package com.javaweb.purchase.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.*;

@Data
@TableName(value="cart")
@EqualsAndHashCode(callSuper = false)
public class Cart extends Model<Cart> {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer thingId;
    private Integer count;
    @TableField(exist = false)
    private Product product;
}
