package com.academy.kocats.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryID;

    private String countryName;

    @JsonManagedReference
    @OneToMany(mappedBy = "country")
    private List<City> cities = new ArrayList<>();


}
