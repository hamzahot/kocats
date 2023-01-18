package com.academy.kocats.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "donor_box")
public class DonorBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer donorBoxId;


    private String location;

}
