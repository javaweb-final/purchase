package com.javaweb.purchase.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class OrderUtils {
    private static long orderNum = 0l;
    private static String date;

    /**
     * 生成订单编号
     */
    public static synchronized String createOrderNum() {
        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        if(date == null || !date.equals(str)){
            date = str;
            orderNum = 0l;
        }
        orderNum ++;
        long orderNo = Long.parseLong(date) * 10000;
        orderNo += orderNum;
        return String.valueOf(orderNo);
    }
}