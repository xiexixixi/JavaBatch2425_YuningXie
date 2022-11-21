package com.example.javabatchspringdemo.Controller;


import com.example.javabatchspringdemo.Entity.ProductItem;
import com.example.javabatchspringdemo.Exception.SystemException;
import com.example.javabatchspringdemo.Repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


/*
get single item
get all items
update
delete
create

 */
@Slf4j
@RestController
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping(path = "/api/product/{id}")
    public ResponseEntity<?> getSingleProductItem(@PathVariable int id){
        Optional<ProductItem> product = productRepository.findByProductIem(id);
        if(product.isEmpty())
            throw new SystemException("Product Not Found", 100); ;

        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping(path = "/api/product")
    public ResponseEntity<?> getSingleProductItem(){
        List<ProductItem> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping(path = "/api/product/create")
    public ResponseEntity<?> createProductItem(@Valid @RequestBody ProductItem product){
        System.out.println(product);
        productRepository.save(product);
        return new ResponseEntity<String>("Product has been created", HttpStatus.CREATED);
    }
    @PostMapping(path = "/api/product/{id}")
    public ResponseEntity<?> createProductItem(@Valid @RequestBody ProductItem product,
                                               @PathVariable int id){
        System.out.println(product);
        Optional<ProductItem> p = productRepository.findByProductIem(id);
        if(p.isEmpty())
            throw new SystemException("Product Not Found", 100);

        productRepository.save(product);
        return new ResponseEntity<String>("Product"+id+" has been changed", HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/api/product/{id}")
    public ResponseEntity<?> createProductItem( @PathVariable int id){
        Optional<ProductItem> p = productRepository.findByProductIem(id);
        if(p.isEmpty())
            throw new SystemException("Product Not Found", 100);

        productRepository.deleteById(id);
        return new ResponseEntity<String>("Product"+id+" has been deleted", HttpStatus.CREATED);
    }

    @ExceptionHandler(SystemException.class)
    public ResponseEntity<?> SystemExceptionHandler(Exception ex){
        logger.warn(ex.getMessage());
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
