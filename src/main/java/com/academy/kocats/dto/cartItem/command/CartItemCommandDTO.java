package com.academy.kocats.dto.cartItem.command;


import lombok.Data;

@Data
public class CartItemCommandDTO {


    private Double amount;
    private Integer cartId;
    private Integer serviceTypeId;
    private Integer catId;

}
