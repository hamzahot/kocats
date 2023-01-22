package com.academy.kocats.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    private int id;

    private String name;

    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private ServiceType serviceType;

}
//id
