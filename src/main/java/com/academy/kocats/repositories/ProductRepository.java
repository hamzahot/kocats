package com.academy.kocats.repositories;


import com.academy.kocats.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    @Query(value = "select product " +
            "from Product product " +
            "join fetch product.serviceType " +
            "where product.id = :id")
    Product getProductById(@Param("id") Integer id);


    @Query(value = "select product " +
            "from Product product " +
            "join fetch product.serviceType")
    List<Product> getAllProducts();

}
