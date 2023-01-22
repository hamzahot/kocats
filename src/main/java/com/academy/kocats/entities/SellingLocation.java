package com.academy.kocats.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "selling_location")
public class SellingLocation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sellingLocationId;


    private String location;
}
