package com.example.javabatchspringdemo;

import com.example.javabatchspringdemo.Entity.ProductItem;
import com.example.javabatchspringdemo.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Date;


@SpringBootTest
class JavaBatchSpringDemoApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    @Rollback(false)
    void contextLoads() {
        productRepository.save(new ProductItem(1,"p1", null));
        System.out.println(productRepository.findByProductIem(1));
    }

}
