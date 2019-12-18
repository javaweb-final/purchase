package com.javaweb.purchase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaweb.purchase.entity.Evaluate;
import com.javaweb.purchase.entity.UserOrderVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateMapper extends BaseMapper<Evaluate> {
    @Select(
            "select user_id,thing_id from order_item,order1 where order1.id=order_item.order_id and order1.user_id=#{user_id} and order_item.thing_id=#{thing_id}"
    )
    List<UserOrderVo> getUserOrder(Integer user_id,Integer thing_id);

}
