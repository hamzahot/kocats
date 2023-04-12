package com.academy.kocats.dto.cartItem.command;


import lombok.Data;

@Data
public class CartItemCommandDTO {


    private Double price;
    private Integer quantity;
    private Integer cartId;
    private Integer serviceTypeId;
    private Integer catId = null;
    private String name = null;
    private String imageName=null;

}
