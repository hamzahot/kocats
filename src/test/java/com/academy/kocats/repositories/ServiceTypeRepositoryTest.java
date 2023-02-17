package com.academy.kocats.repositories;


import com.academy.kocats.KocatsApplication;
import com.academy.kocats.entities.Product;
import com.academy.kocats.entities.ServiceType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Slf4j
@ActiveProfiles("dev")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KocatsApplication.class)
public class ServiceTypeRepositoryTest {


    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Autowired
    ProductRepository productRepository;


    @Test
    void shouldReturnProductById(){

//        ServiceType serviceType = serviceTypeRepository.getServiceTypeById(4);
//
//        Product product = new Product();
//        product.setServiceType(serviceType);
//
//
//
//        log.info(product.getName());
//        log.info(product.getDescription());


        Product product = productRepository.getProductById(4);
        log.info(product.getName());
        log.info(product.getDescription());
        log.info(product.getServiceType().getPrice().toString());



        //ovo je insert product
//        ServiceType serviceType = new ServiceType();
//        serviceType.setPrice(3.67);
//
//        Product product = new Product();
//        product.setServiceType(serviceType);
//        product.setName("test 1");
//        product.setDescription("proba 1");
//
//        productRepository.save(product);

    }



    @Test
    void shouldUpdatePrice(){

        ServiceType serviceType = serviceTypeRepository.getServiceTypeById(4);
        serviceType.setPrice(6.00);

        serviceTypeRepository.save(serviceType);

    }


    @Test
    void shouldReturnAllProducts(){
        List<Product> products = productRepository.getAllProducts();

        for(Product p : products){
            log.info(p.getName());
            log.info(p.getDescription());
            log.info(p.getServiceType().getPrice().toString());
        }

    }


}
