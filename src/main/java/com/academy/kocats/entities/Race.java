package com.academy.kocats.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@DynamicInsert
@DynamicUpdate
@Table(name = "race")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "race_id")
    private Integer raceId;


    private String name;


    @JsonIgnore
    @ManyToMany(mappedBy = "breeds")
    private Set<Cat> cats = new HashSet<>();

}
