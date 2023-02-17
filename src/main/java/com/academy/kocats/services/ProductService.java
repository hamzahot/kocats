package com.academy.kocats.services;


import com.academy.kocats.dto.product.command.ProductCreateDTO;
import com.academy.kocats.dto.product.query.ProductQueryDTO;
import com.academy.kocats.entities.Product;
import com.academy.kocats.entities.ServiceType;
import com.academy.kocats.mappers.ProductMapper;
import com.academy.kocats.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private ProductMapper productMapper;



    public void insertProduct(ProductCreateDTO productCreateDTO) {

        Product product = productMapper.toEntity(productCreateDTO);

        ServiceType serviceType = new ServiceType();
        serviceType.setPrice(productCreateDTO.getPrice());
        serviceType.setCategory("product");

        product.setServiceType(serviceType);

        productRepository.save(product);

    }



    public ProductQueryDTO getProductById(Integer id) {
        return productMapper.toProductQueryDTO(productRepository.getProductById(id));
    }


    public List<ProductQueryDTO> getAllProducts() {
        return productRepository.getAllProducts().stream().map(productMapper :: toProductQueryDTO).toList();
    }


    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
