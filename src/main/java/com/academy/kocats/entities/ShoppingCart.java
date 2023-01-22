package com.academy.kocats.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    private int id;

    @Column(name = "total_price")
    private double totalPrice;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonBackReference
    @JoinColumn(name = "userId")
    private User user;


    @JsonManagedReference
    @OneToMany(mappedBy = "shoppingCart")
    private List<CartItem> cartItems = new ArrayList<>();

}
