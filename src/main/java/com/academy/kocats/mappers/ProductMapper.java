package com.academy.kocats.mappers;


import com.academy.kocats.dto.product.command.ProductCreateDTO;
import com.academy.kocats.dto.product.command.ProductUpdateDTO;
import com.academy.kocats.dto.product.query.ProductQueryDTO;
import com.academy.kocats.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {


    Product toEntity(ProductCreateDTO productCreateDTO);

    Product UpdateDTOtoEntity(ProductUpdateDTO productUpdateDTO);

    @Mapping(source = "product.serviceType.price" , target = "price")
    ProductQueryDTO toProductQueryDTO(Product product);

}
