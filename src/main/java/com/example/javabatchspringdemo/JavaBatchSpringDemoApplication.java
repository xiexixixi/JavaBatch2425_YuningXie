package com.example.javabatchspringdemo;

import com.example.javabatchspringdemo.Entity.ProductItem;
import com.example.javabatchspringdemo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaBatchSpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaBatchSpringDemoApplication.class, args);
    }

}
