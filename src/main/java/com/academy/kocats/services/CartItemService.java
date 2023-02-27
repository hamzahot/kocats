package com.academy.kocats.services;


import com.academy.kocats.dto.cartItem.command.CartItemCommandDTO;
import com.academy.kocats.dto.cartItem.query.CartItemQueryDTO;
import com.academy.kocats.entities.CartItem;
import com.academy.kocats.entities.Cat;
import com.academy.kocats.entities.ServiceType;
import com.academy.kocats.entities.ShoppingCart;
import com.academy.kocats.mappers.CartItemMapper;
import com.academy.kocats.repositories.CartItemRepository;
import com.academy.kocats.repositories.CatRepository;
import com.academy.kocats.repositories.ServiceTypeRepository;
import com.academy.kocats.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Autowired
    private CartItemMapper cartItemMapper;




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

    public CartItemQueryDTO getById(Integer id) {
        return cartItemMapper.toQueryDTO(cartItemRepository.getById(id));
    }

    public List<CartItemQueryDTO> getAll() {
        return cartItemRepository.getAll().stream().map(cartItemMapper :: toQueryDTO).toList();
    }

    public List<CartItemQueryDTO> getAllFromCart(Integer id) {
        return cartItemRepository.getAllFromCart(id).stream().map(cartItemMapper :: toQueryDTO).toList();
    }

    public void deleteById(Integer id) {
        cartItemRepository.deleteById(id);
    }

    public void deleteFromCart(Integer id) {
       for(CartItem item : cartItemRepository.getAllFromCart(id)){
           cartItemRepository.delete(item);
       }
    }
}
