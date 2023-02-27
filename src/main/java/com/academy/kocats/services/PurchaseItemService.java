package com.academy.kocats.services;


import com.academy.kocats.dto.cartItem.query.CartItemQueryDTO;
import com.academy.kocats.entities.*;
import com.academy.kocats.repositories.CatRepository;
import com.academy.kocats.repositories.PurchaseItemRepository;
import com.academy.kocats.repositories.ServiceTypeRepository;
import com.academy.kocats.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseItemService {


    @Autowired
    private PurchaseItemRepository purchaseItemRepository;




}
