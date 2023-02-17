package com.academy.kocats.controllers;


import com.academy.kocats.dto.product.command.ProductCreateDTO;
import com.academy.kocats.dto.product.query.ProductQueryDTO;
import com.academy.kocats.entities.Product;
import com.academy.kocats.entities.ServiceType;
import com.academy.kocats.services.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-type")
public class ServiceTypeController {


    @Autowired
    private ServiceTypeService serviceTypeService;


//    @GetMapping(value = "products")
//    public ResponseEntity<List<Product>> getAllProducts(){
//        List<Product> products = serviceTypeService.getAllProducts();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }


    @GetMapping
    public ResponseEntity<List<ServiceType>> getAllServiceTypes(){
        List<ServiceType> serviceTypes = serviceTypeService.getAllServiceTypes();
        return new ResponseEntity<>(serviceTypes, HttpStatus.OK);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<ServiceType> getServiceTypeById(@PathVariable("id") Integer id){
        ServiceType serviceType = serviceTypeService.getServiceTypeById(id);
        return new ResponseEntity<>(serviceType, HttpStatus.OK);
    }


    @PutMapping(value = "{id}")
    public ResponseEntity<Void> updatePrice(@PathVariable("id") Integer id, @RequestParam(value = "price") Double price){
        serviceTypeService.updatePrice(id, price);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
