package com.javaweb.purchase;

import com.javaweb.purchase.entity.Evaluate;
import com.javaweb.purchase.mapper.CartMapper;
import com.javaweb.purchase.mapper.OrderMapper;
import com.javaweb.purchase.service.EvaluateService;
import com.javaweb.purchase.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class PurchaseApplicationTests {
    @Autowired
    private  ProductService productService;
    @Autowired
    private CartMapper cartMapper;
//    @Test
//    public void findProductList() {
//        productService.list().forEach(System.out::println);
//    }
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private EvaluateService evaluateService;

//    @Test
//    public void contextLoads() {
//    }
//    @Test
//    public void finfCartList(){
//        cartMapper.findCartListByUserId(2).forEach(System.out::println);
//    }
    @Test
    public void findOrderList(){
//        orderMapper.findOrderAndOrderDetailListByUser()
        evaluateService.findUserOrder(2,9).forEach(System.out::print);
    }


}
