package com.javaweb.purchase.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.javaweb.purchase.entity.enums.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.Locale;

@Data
@TableName(value = "thing")
@EqualsAndHashCode(callSuper = false)
public class Product extends Model<Product> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer bossId;

    private double oldPrice;
    private double newPrice;
    private Category category;
    private String info;
    private String imgUrl;
}

