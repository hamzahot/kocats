package com.academy.kocats.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Table(name = "cat")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer catId;


    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "cat")
    private List<PurchaseItem> purchaseItems = new ArrayList<>();


    @JsonManagedReference
    @OneToMany(mappedBy = "cat")
    private List<CatPhoto> catPhotos = new ArrayList<>();





    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cat_race",
            joinColumns = @JoinColumn(name = "catId"),
            inverseJoinColumns = @JoinColumn(name = "raceId")
    )
    private Set<Race> breeds = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cat_status",
            joinColumns = @JoinColumn(name = "catId"),
            inverseJoinColumns = @JoinColumn(name = "statusId")
    )
    private Set<Status> statuses = new HashSet<>();

    //race status

}
