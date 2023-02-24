package com.academy.kocats.repositories;


import com.academy.kocats.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {


    @Query(value = "select cartItem " +
            "from CartItem cartItem " +
            "join fetch cartItem.shoppingCart " +
            "join fetch cartItem.cat " +
            "join fetch cartItem.serviceType " +
            "where cartItem.cartItemId = :id")
    CartItem getById(@Param("id") Integer id);



    @Query(value = "select cartItem " +
            "from CartItem cartItem " +
            "join fetch cartItem.shoppingCart " +
            "join fetch cartItem.cat " +
            "join fetch cartItem.serviceType")
    List<CartItem> getAll();



    @Query(value = "select cartItem " +
            "from CartItem cartItem " +
            "join fetch cartItem.shoppingCart " +
            "join fetch cartItem.cat " +
            "join fetch cartItem.serviceType " +
            "where cartItem.shoppingCart.id = :id")
    List<CartItem> getAllFromCart(@Param("id") Integer id);




}
