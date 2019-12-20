package com.javaweb.purchase.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName(value = "superadmin")
@EqualsAndHashCode(callSuper = false)
public class Super {
    private String username;
    private String password;
}
