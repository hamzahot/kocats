package com.academy.kocats.repositories;


import com.academy.kocats.KocatsApplication;
import com.academy.kocats.entities.CartItem;
import com.academy.kocats.entities.Cat;
import com.academy.kocats.entities.ServiceType;
import com.academy.kocats.entities.ShoppingCart;
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
public class CartItemRepositoryTest {


    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private CatRepository catRepository;


    @Test
    void shouldAdd(){

        CartItem cartItem = new CartItem();
        cartItem.setAmount(5.00);

        ShoppingCart shoppingCart = userRepository.findByUId(1).getShoppingCart();
        cartItem.setShoppingCart(shoppingCart);

        ServiceType serviceType = serviceTypeRepository.getServiceTypeById(4);
        cartItem.setServiceType(serviceType);

        Cat cat = catRepository.findByCatId(1);
        cartItem.setCat(cat);

        cartItemRepository.save(cartItem);


        ShoppingCart shoppingCart1 = userRepository.findByUId(1).getShoppingCart();


        for(CartItem cartItem1 : shoppingCart1.getCartItems()){
            log.info(cartItem1.getCartItemId().toString());
        }

    }



}
