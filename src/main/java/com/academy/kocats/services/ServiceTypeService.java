package com.academy.kocats.services;


import com.academy.kocats.dto.product.command.ProductCreateDTO;
import com.academy.kocats.dto.product.query.ProductQueryDTO;
import com.academy.kocats.entities.Product;
import com.academy.kocats.entities.ServiceType;
import com.academy.kocats.mappers.ProductMapper;
import com.academy.kocats.repositories.ProductRepository;
import com.academy.kocats.repositories.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService {


    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private ProductMapper productMapper;


    @Autowired
    private ProductRepository productRepository;





    public List<ServiceType> getAllServiceTypes() {

        return serviceTypeRepository.getAllServiceTypes();

    }

    public ServiceType getServiceTypeById(Integer id) {

        return serviceTypeRepository.getServiceTypeById(id);

    }


    public void updatePrice(Integer id, Double price) {

        ServiceType serviceType = serviceTypeRepository.getServiceTypeById(id);
        serviceType.setPrice(price);
        serviceTypeRepository.save(serviceType);

    }



}
