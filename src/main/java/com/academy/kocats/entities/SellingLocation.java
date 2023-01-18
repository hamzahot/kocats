package com.academy.kocats.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "selling_location")
public class SellingLocation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sellingLocationId;


    private String location;
}
