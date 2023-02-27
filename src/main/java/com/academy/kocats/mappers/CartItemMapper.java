package com.academy.kocats.mappers;


import com.academy.kocats.dto.cartItem.query.CartItemQueryDTO;
import com.academy.kocats.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CartItemMapper {


    @Mapping(source = "cartItemId" , target = "id")
    @Mapping(source = "shoppingCart.id" , target = "cartId")
    @Mapping(source = "cat" , target = "catDTO")
    @Mapping(source = "serviceType" , target = "serviceTypeDTO")
    CartItemQueryDTO toQueryDTO(CartItem cartItem);




    ////item -> cart is lazily initialized


}
