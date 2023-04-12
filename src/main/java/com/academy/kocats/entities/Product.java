package com.academy.kocats.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "product")
public class Product {

    @Id
    private Integer id;

    private String name;

    private String description;

    @Column(name = "image_name")
    private String imageName;




    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private ServiceType serviceType;

}
//id
