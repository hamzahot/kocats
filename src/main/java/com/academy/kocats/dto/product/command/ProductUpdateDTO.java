package com.academy.kocats.dto.product.command;


import lombok.Data;

@Data
public class ProductUpdateDTO {

    private String name;
    private String description;
    private Double price;


}
