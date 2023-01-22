package com.academy.kocats.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "donor_box")
public class DonorBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer donorBoxId;


    private String location;

}
