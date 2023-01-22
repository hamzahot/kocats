package com.academy.kocats.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;

    private Double amount;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId")
    private ShoppingCart shoppingCart;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catId")
    private Cat cat;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serviceType")
    private ServiceType serviceType;


}
