package com.javaweb.purchase;

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
    @Test
    public void findProductList() {
        productService.list().forEach(System.out::println);
    }
    @Test
    public void contextLoads() {
    }

}
