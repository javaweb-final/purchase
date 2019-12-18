package com.javaweb.purchase.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.lang.reflect.Type;

@Data
@TableName("evaluate")
public class Evaluate {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer thingId;
    private String detail;
    private Integer userId;

}
