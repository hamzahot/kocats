package com.academy.kocats.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Table(name = "status")
public class Status {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statusId;

    private String name;

    private Date date;



    @JsonIgnore
    @ManyToMany(mappedBy = "statuses")
    private Set<Cat> cats = new HashSet<>();


}
