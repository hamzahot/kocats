package com.academy.kocats.repositories;


import com.academy.kocats.KocatsApplication;
import com.academy.kocats.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ActiveProfiles("dev")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KocatsApplication.class)
public class PurchaseItemRepoTest {


    @Autowired
    private PurchaseItemRepository purchaseItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;


    @Test
    void shouldSaveItem(){
        Purchase purchase = new Purchase();

        User user = userRepository.findByUserId(1);

        purchase.setUser(user);

        Cat cat = catRepository.findByCatId(1);
        ServiceType serviceType = serviceTypeRepository.getServiceTypeById(4);

        PurchaseItem purchaseItem = new PurchaseItem();
        purchaseItem.setAmount(69.69);
        purchaseItem.setPurchase(purchase);
        purchaseItem.setCat(cat);
        purchaseItem.setServiceType(serviceType);

        purchaseItemRepository.save(purchaseItem);

    }


}
