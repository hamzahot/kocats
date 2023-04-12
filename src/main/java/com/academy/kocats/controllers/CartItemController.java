package com.academy.kocats.controllers;


import com.academy.kocats.dto.cartItem.command.CartItemCommandDTO;
import com.academy.kocats.dto.cartItem.query.CartItemQueryDTO;
import com.academy.kocats.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartItem")
public class CartItemController {


    @Autowired
    private CartItemService cartItemService;


    @PostMapping
    public ResponseEntity<Void> add(@RequestBody CartItemCommandDTO cartItemCommandDTO){
        cartItemService.add(cartItemCommandDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @GetMapping(value = "{id}")
    public ResponseEntity<CartItemQueryDTO> getById(@PathVariable("id") Integer id){
        CartItemQueryDTO cartItemQueryDTO = cartItemService.getById(id);
        return new ResponseEntity<>(cartItemQueryDTO, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<CartItemQueryDTO>> getAll(){
        List<CartItemQueryDTO> cartItemQueryDTOS = cartItemService.getAll();
        return new ResponseEntity<>(cartItemQueryDTOS, HttpStatus.OK);
    }


    @GetMapping(value = "cart/{id}")
    public ResponseEntity<List<CartItemQueryDTO>> getAllFromCart(@PathVariable("id") Integer id){
        List<CartItemQueryDTO> cartItemQueryDTOS = cartItemService.getAllFromCart(id);
        return new ResponseEntity<>(cartItemQueryDTOS, HttpStatus.OK);
    }



    @DeleteMapping(value = "{id}/{productId}")
    public ResponseEntity<Void> deleteItemById(@PathVariable("id") Integer id, @PathVariable("productId") Integer productId){
        cartItemService.deleteProductFromCart(id, productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "{id}/{actionId}/{catId}")
    public ResponseEntity<Void> deleteActionFromCart(@PathVariable("id") Integer id, @PathVariable("actionId") Integer actionId,
                                                     @PathVariable("catId") Integer catId){
        cartItemService.deleteActionFromCart(id, actionId, catId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping(value = "cart/{id}")
    public ResponseEntity<Void> deleteAllFromCart(@PathVariable("id") Integer id){
        cartItemService.deleteFromCart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping(value = "add-quantity/{id}/{productId}")
    public ResponseEntity<Void> increaseQuantity(@PathVariable("id") Integer id, @PathVariable("productId") Integer productId){
        cartItemService.increaseQuantity(id, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "reduce-quantity/{id}/{productId}")
    public ResponseEntity<Void> decreaseQuantity(@PathVariable("id") Integer id, @PathVariable("productId") Integer productId ){
        cartItemService.reduceQuantity(id, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "exists/{id}/{productId}")
    public ResponseEntity<Boolean> productExistsInCart(@PathVariable("id") Integer id , @PathVariable("productId") Integer productId){
        Boolean b = cartItemService.existsInCart(id, productId);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }


    @GetMapping(value = "get-total/{id}")
    public ResponseEntity<Double> getTotal(@PathVariable("id") Integer id){
        Double sum = cartItemService.getTotal(id);
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }


    @GetMapping(value = "number-of-items/{id}")
    public ResponseEntity<Integer> getNumberOfItemsInCart(@PathVariable("id") Integer id){
        Integer number = cartItemService.getNumber(id);
        return new ResponseEntity<>(number, HttpStatus.OK);
    }








}
