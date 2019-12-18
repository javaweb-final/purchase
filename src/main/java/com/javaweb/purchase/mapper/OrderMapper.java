package com.javaweb.purchase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaweb.purchase.entity.Order;
import com.javaweb.purchase.entity.OrderQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 根据用户id查询用户订单以及订单明细
     */
//    List<Order> findOrderAndOrderDetailListByUser(@Param("userId") Integer id, @Param("begin")Integer begin, @Param("end")Integer end);
    List<Order> findOrderAndOrderDetailListByUser(OrderQueryVo orderQueryVo);

    /**
     * 查询记录总数
     */
    Integer findOrderCountByUser(OrderQueryVo orderQueryVo);
}