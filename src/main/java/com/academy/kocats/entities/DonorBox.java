package com.academy.kocats.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Table(name = "donor_box")
public class DonorBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer donorBoxId;


    private String location;

}
