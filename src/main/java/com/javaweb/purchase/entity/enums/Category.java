package com.javaweb.purchase.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum Category {
    Bai(1,"百货"),Mei(2,"美妆"),Jia(3,"家具"),Nan(4,"男装"),Nvz(5,"女装"),Shu(6,"数码"),Muy(7,"母婴");

    Category(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @EnumValue//标记数据库存的值是code
    private final int code;
    private final String desc;
}
