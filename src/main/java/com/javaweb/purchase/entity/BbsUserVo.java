package com.javaweb.purchase.entity;

import lombok.Data;
import java.util.Date;

@Data
public class BbsUserVo {
    private String username;
    private String title;
    private String info;
    private Date time;
    private Integer id;
}
