package com.javaweb.purchase.entity;

import lombok.Data;

@Data
public class CartVo {
    private Integer id;
    private Integer userId;
    private Integer thingId;
    private Integer count;
    private String thingName;
    private String imgUrl;
    private double newPrice;
}