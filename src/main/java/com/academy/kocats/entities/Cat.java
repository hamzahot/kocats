package com.academy.kocats.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@NoArgsConstructor
@Getter
@DynamicInsert
@DynamicUpdate
@Table(name = "cat")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Integer catId;


    private String name;


    @Column(name = "is_sterilized")
    private Boolean isSterilized = false;

    private String gender;

    @Column(name = "year_born")
    private Integer yearBorn;



//    @OneToMany(mappedBy = "cat")
//    private List<CartItem> cartItems = new ArrayList<>();


   // @JsonManagedReference
    @OneToMany(mappedBy = "cat", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CatPhoto> catPhotos = new ArrayList<>();





    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cat_race",
            joinColumns = @JoinColumn(name = "cat_id"),
            inverseJoinColumns = @JoinColumn(name = "race_id")
    )
    private Set<Race> breeds = new HashSet<>();




}
