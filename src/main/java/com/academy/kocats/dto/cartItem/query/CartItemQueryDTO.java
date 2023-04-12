package com.academy.kocats.dto.cartItem.query;


import com.academy.kocats.dto.cat.query.CatGetDTO;
import com.academy.kocats.dto.service_type.ServiceTypeDTO;
import lombok.Data;

@Data
public class CartItemQueryDTO {

    private Integer id;
    private Double price;
    private Integer quantity;
    private Integer cartId;
    private CatGetDTO catDTO=null;
    private ServiceTypeDTO serviceTypeDTO;
    private String name;
    private String imageName;

}
