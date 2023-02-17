package com.academy.kocats.controllers;


import com.academy.kocats.dto.product.command.ProductCreateDTO;
import com.academy.kocats.dto.product.query.ProductQueryDTO;
import com.academy.kocats.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;



    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ProductCreateDTO productCreateDTO){
        productService.insertProduct(productCreateDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<ProductQueryDTO> getById(@PathVariable("id") Integer id){
        ProductQueryDTO productQueryDTO = productService.getProductById(id);
        return new ResponseEntity<>(productQueryDTO, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<ProductQueryDTO>> getAll(){
        List<ProductQueryDTO> productQueryDTOS = productService.getAllProducts();
        return new ResponseEntity<>(productQueryDTOS, HttpStatus.OK);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
