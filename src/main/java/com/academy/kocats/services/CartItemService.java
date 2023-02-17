package com.academy.kocats.services;


import com.academy.kocats.dto.cartItem.command.CartItemCommandDTO;
import com.academy.kocats.entities.CartItem;
import com.academy.kocats.entities.Cat;
import com.academy.kocats.entities.ServiceType;
import com.academy.kocats.entities.ShoppingCart;
import com.academy.kocats.repositories.CartItemRepository;
import com.academy.kocats.repositories.CatRepository;
import com.academy.kocats.repositories.ServiceTypeRepository;
import com.academy.kocats.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {


    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;





    public void add(CartItemCommandDTO cartItemCommandDTO) {

        ShoppingCart shoppingCart = userRepository.findByUId(cartItemCommandDTO.getCartId()).getShoppingCart();
        Cat cat = catRepository.findByCatId(cartItemCommandDTO.getCatId());
        ServiceType serviceType = serviceTypeRepository.getServiceTypeById(cartItemCommandDTO.getServiceTypeId());


        CartItem cartItem = new CartItem();
        cartItem.setAmount(cartItemCommandDTO.getAmount());
        cartItem.setShoppingCart(shoppingCart);
        cartItem.setCat(cat);
        cartItem.setServiceType(serviceType);

        cartItemRepository.save(cartItem);


    }
}
