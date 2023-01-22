package com.academy.kocats.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "donation")
public class Donation {

    @Id
    private int id;

    private String letter;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private ServiceType serviceType;


    //id
}
