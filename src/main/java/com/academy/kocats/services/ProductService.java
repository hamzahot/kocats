package com.academy.kocats.services;


import com.academy.kocats.dto.product.command.ProductCreateDTO;
import com.academy.kocats.dto.product.command.ProductUpdateDTO;
import com.academy.kocats.dto.product.query.ProductQueryDTO;
import com.academy.kocats.entities.Product;
import com.academy.kocats.entities.ServiceType;
import com.academy.kocats.mappers.ProductMapper;
import com.academy.kocats.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private ProductMapper productMapper;


    @Value("${fs.front-Url}")
    private String frontFilePath;


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

    public void update(Integer id, ProductUpdateDTO productUpdateDTO) {

        Product product = productRepository.getProductById(id);
        product.setName(productUpdateDTO.getName());
        product.setDescription(productUpdateDTO.getDescription());
        product.getServiceType().setPrice(productUpdateDTO.getPrice());

        productRepository.save(product);

    }

    public void addPhoto(MultipartFile multipartFile, Integer id) throws IOException {

        String originalName = new Date().getTime() + "_" +  multipartFile.getOriginalFilename();

        String fullPath = frontFilePath + originalName;
        Path path = Paths.get(fullPath);
        Files.write(path, multipartFile.getBytes());

        Product product = productRepository.getProductById(id);
        product.setImageName(originalName);

        productRepository.save(product);

    }
}
