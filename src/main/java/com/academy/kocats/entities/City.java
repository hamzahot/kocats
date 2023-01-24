package com.academy.kocats.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "city_name")
    private String cityName;

    @ManyToOne(fetch = FetchType.LAZY)
   // @JsonBackReference
    @JoinColumn(name = "country_id")
    private Country country;

   // @JsonManagedReference
    @OneToMany(mappedBy = "city")
    private List<User> users = new ArrayList<>();

}
