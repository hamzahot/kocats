package com.academy.kocats.dto.product.query;

import lombok.Data;

@Data
public class ProductQueryDTO {

    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String imageName;

}
