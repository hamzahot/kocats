package com.academy.kocats.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    private Integer id;

    @Column(name = "total_price")
    private Double totalPrice ;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    //@JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;


    //@JsonManagedReference
    @OneToMany(mappedBy = "shoppingCart", fetch = FetchType.EAGER)
    private List<CartItem> cartItems = new ArrayList<>();

}
