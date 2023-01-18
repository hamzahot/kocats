package com.academy.kocats.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends ServiceType {


    private String name;

    private String description;

}
//id
