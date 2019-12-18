package com.javaweb.purchase.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.purchase.entity.Evaluate;
import com.javaweb.purchase.entity.UserOrderVo;
import com.javaweb.purchase.mapper.EvaluateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateService extends ServiceImpl<EvaluateMapper, Evaluate> {
    @Autowired
    private EvaluateMapper evaluateMapper;
    public List<UserOrderVo> findUserOrder(Integer user_id,Integer thing_id){
        return evaluateMapper.getUserOrder(user_id,thing_id);
    }
}
