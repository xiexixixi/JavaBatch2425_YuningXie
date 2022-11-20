package com.example.javabatchspringdemo.Repository;

import com.example.javabatchspringdemo.Entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductItem, Integer> {
    @Query("SELECT p FROM ProductItem as p WHERE p.id = ?1")
    Optional<ProductItem> findByProductIem(Integer pid);




}
