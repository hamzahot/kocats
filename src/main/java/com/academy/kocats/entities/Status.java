package com.academy.kocats.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Table(name = "status")
public class Status {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Integer statusId;

    private String name;

    private Date date;



    @JsonIgnore
    @ManyToMany(mappedBy = "statuses")
    private Set<Cat> cats = new HashSet<>();


}
