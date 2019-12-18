package com.javaweb.purchase.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.purchase.entity.Address;
import com.javaweb.purchase.mapper.AddressMapper;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends ServiceImpl<AddressMapper, Address> {
}