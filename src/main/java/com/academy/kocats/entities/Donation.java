package com.academy.kocats.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "donation")
public class Donation {

    @Id
    private Integer id;

    private String letter;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private ServiceType serviceType;


    //id
}
