package com.academy.kocats.controllers;

import com.academy.kocats.dto.cartItem.query.CartItemQueryDTO;
import com.academy.kocats.services.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/purchaseItem")
public class PurchaseItemController {


    @Autowired
    private PurchaseItemService purchaseItemService;






}
