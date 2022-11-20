package com.example.javabatchspringdemo.Controller;


import com.example.javabatchspringdemo.Entity.ProductItem;
import com.example.javabatchspringdemo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


/*
get single item
get all items
update
delete
create

 */
@RestController
public class ProductController {

    final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping(path = "/api/product/{id}")
    public ResponseEntity<?> getSingleItem(@PathVariable int id){
        Optional<ProductItem> product = productRepository.findByProductIem(id);
        if(product.isEmpty()) /* throw exception, no such product*/
            return new ResponseEntity<String>("Hello world", HttpStatus.OK);;

        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
