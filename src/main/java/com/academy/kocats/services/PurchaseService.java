package com.academy.kocats.services;


import com.academy.kocats.dto.cartItem.query.CartItemQueryDTO;
import com.academy.kocats.entities.*;
import com.academy.kocats.repositories.CatRepository;
import com.academy.kocats.repositories.PurchaseRepository;
import com.academy.kocats.repositories.ServiceTypeRepository;
import com.academy.kocats.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {


    @Autowired
    private PurchaseRepository purchaseRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;




    public void addList(List<CartItemQueryDTO> items) {

        Purchase purchase = new Purchase();

        Integer userId = items.get(0).getCartId();
        User user = userRepository.findByUserId(userId);

        purchase.setUser(user);

        List<PurchaseItem> itemList = new ArrayList<>();

        for(CartItemQueryDTO item : items){

            Cat cat = catRepository.findByCatId(item.getCatDTO().getCatId());
            ServiceType serviceType = serviceTypeRepository.getServiceTypeById(item.getServiceTypeDTO().getServiceTypeId());

            PurchaseItem purchaseItem = new PurchaseItem();
            //purchaseItem.setAmount(item.getAmount());
            purchaseItem.setPurchase(purchase);
            purchaseItem.setCat(cat);
            purchaseItem.setServiceType(serviceType);

            itemList.add(purchaseItem);

        }

        purchase.setPurchaseItems(itemList);

        purchaseRepository.save(purchase);

    }
}
