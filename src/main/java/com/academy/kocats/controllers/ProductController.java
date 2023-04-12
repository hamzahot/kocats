package com.academy.kocats.controllers;


import com.academy.kocats.dto.product.command.ProductCreateDTO;
import com.academy.kocats.dto.product.command.ProductUpdateDTO;
import com.academy.kocats.dto.product.query.ProductQueryDTO;
import com.academy.kocats.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id ,@RequestBody ProductUpdateDTO productUpdateDTO){
        productService.update(id, productUpdateDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "addPhoto/{id}")
    public ResponseEntity<Void> addPhotoToProduct(@PathVariable("id") Integer id, @RequestParam("photo") MultipartFile multipartFile) throws IOException {
        productService.addPhoto(multipartFile, id);
        return new ResponseEntity<>(HttpStatus.OK);
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
