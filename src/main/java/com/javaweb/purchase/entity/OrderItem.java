package com.javaweb.purchase.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName(value = "order_item")
@EqualsAndHashCode(callSuper = false)
public class OrderItem extends Model<OrderItem> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer orderId;
    private Integer thingId;
    private Integer count;

    //图书对象
    @TableField(exist = false)
    private Product thing;
}