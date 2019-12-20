package com.javaweb.purchase.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.javaweb.purchase.entity.enums.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@TableName(value = "bbs")
@EqualsAndHashCode(callSuper = false)
public class Bbs extends Model<Bbs> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer user_id;
    private String title;
    private String info;
    private Date time;
}
