package com.javaweb.purchase.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.purchase.entity.OrderItem;
import com.javaweb.purchase.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;


@Service
public class OrderItemService extends ServiceImpl<OrderItemMapper,OrderItem> {
}
