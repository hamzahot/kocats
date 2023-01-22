package com.academy.kocats.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
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
