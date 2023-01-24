package com.academy.kocats.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "product")
public class Product {

    @Id
    private Integer id;

    private String name;

    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private ServiceType serviceType;

}
//id
