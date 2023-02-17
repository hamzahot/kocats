package com.academy.kocats.controllers;


import com.academy.kocats.dto.cartItem.command.CartItemCommandDTO;
import com.academy.kocats.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
