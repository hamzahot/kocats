package com.academy.kocats.dto.action.command;


import lombok.Data;

@Data
public class ActionUpdateDTO {

    private Integer id;
    private String name;
    private String description;
    private Double price;


}
