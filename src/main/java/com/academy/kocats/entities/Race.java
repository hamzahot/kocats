package com.academy.kocats.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Table(name = "race")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer raceId;


    private String name;


    @JsonIgnore
    @ManyToMany(mappedBy = "breeds")
    private Set<Cat> cats = new HashSet<>();

}
