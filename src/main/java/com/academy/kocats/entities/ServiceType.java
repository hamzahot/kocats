package com.academy.kocats.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Table(name = "service_type")
public class ServiceType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Integer serviceTypeId;

    private Date date;

    private Double price;

}
