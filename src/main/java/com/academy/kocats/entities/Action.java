package com.academy.kocats.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "action")
public class Action {

    @Id
    private int id;

    private String name;

    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private ServiceType serviceType;



}
