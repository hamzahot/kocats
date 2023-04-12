package com.academy.kocats.services;


import com.academy.kocats.dto.cartItem.command.CartItemCommandDTO;
import com.academy.kocats.dto.cartItem.query.CartItemQueryDTO;
import com.academy.kocats.entities.CartItem;
import com.academy.kocats.entities.Cat;
import com.academy.kocats.entities.ServiceType;
import com.academy.kocats.entities.ShoppingCart;
import com.academy.kocats.mappers.CartItemMapper;
import com.academy.kocats.repositories.*;
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
    private ProductRepository productRepository;

    @Autowired
    private CartItemMapper cartItemMapper;




    public void add(CartItemCommandDTO cartItemCommandDTO) {

        ShoppingCart shoppingCart = userRepository.findByUId(cartItemCommandDTO.getCartId()).getShoppingCart();
        CartItem cartItem = new CartItem();
        if(cartItemCommandDTO.getCatId() != null){
            Cat cat = catRepository.findByCatId(cartItemCommandDTO.getCatId());
            cartItem.setCat(cat);
        }
        ServiceType serviceType = serviceTypeRepository.getServiceTypeById(cartItemCommandDTO.getServiceTypeId());





        cartItem.setShoppingCart(shoppingCart);
        cartItem.setServiceType(serviceType);

        if(serviceType.getCategory().equals("product")){
            cartItem.setQuantity(cartItemCommandDTO.getQuantity());
            cartItem.setPrice(cartItemCommandDTO.getPrice());
            cartItem.setImageName(productRepository.getImageNameById(serviceType.getServiceTypeId()));
            cartItem.setName(productRepository.getNameById(serviceType.getServiceTypeId()));
        }
        else if(serviceType.getCategory().equals("action")){
            cartItem.setQuantity(1);
            cartItem.setPrice(serviceType.getPrice());
            cartItem.setName(cartItemCommandDTO.getName());
            cartItem.setImageName(cartItemCommandDTO.getImageName());

            cartItem.setImageName(cartItemCommandDTO.getImageName());
        }

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

    public void deleteProductFromCart(Integer id, Integer productId){
        List<CartItem> list = cartItemRepository.getAllFromCart(id);
        for(CartItem item : list){
            if(item.getServiceType().getServiceTypeId().equals(productId)){
                cartItemRepository.delete(item);
                break;
            }
        }
    }



    public void deleteFromCart(Integer id) {
       for(CartItem item : cartItemRepository.getAllFromCart(id)){
           cartItemRepository.delete(item);
       }
    }

    public void increaseQuantity(Integer id, Integer productId) {
//        CartItem cartItem = cartItemRepository.getById(id);
//        cartItem.setQuantity(cartItem.getQuantity() + 1);
//        cartItemRepository.save(cartItem);
        List<CartItem> list = cartItemRepository.getAllFromCart(id);
        for(CartItem item : list){
            if(item.getServiceType().getServiceTypeId().equals(productId)){
                item.setQuantity(item.getQuantity() + 1);
                cartItemRepository.save(item);
                break;
            }
        }
    }

    public void reduceQuantity(Integer id, Integer productId) {
        List<CartItem> list = cartItemRepository.getAllFromCart(id);
        for(CartItem item : list){
            if(item.getServiceType().getServiceTypeId().equals(productId)){
                item.setQuantity(item.getQuantity() - 1);
                cartItemRepository.save(item);
                break;
            }
        }
    }

    public Boolean existsInCart(Integer id, Integer productId) {
        List<CartItem> list = cartItemRepository.getAllFromCart(id);
        for(CartItem item : list){
            if(item.getServiceType().getServiceTypeId().equals(productId)){
                return true;
            }
        }
            return false;
    }


    public Double getTotal(Integer id) {
        List<CartItem> list = cartItemRepository.getAllFromCart(id);
        Double sum = 0.0;
        for(CartItem item : list){
            sum += item.getPrice()*item.getQuantity();
        }
        return sum;
    }

    public Integer getNumber(Integer id) {
        List<CartItem> list = cartItemRepository.getAllFromCart(id);
        Integer size = 0;
        for(CartItem item : list){
            size += item.getQuantity();
        }
        return size;
    }

    public void deleteActionFromCart(Integer id, Integer actionId, Integer catId) {
        List<CartItem> list = cartItemRepository.getAllFromCart(id);
        for(CartItem item : list){
            if(item.getServiceType().getServiceTypeId().equals(actionId) && item.getCat().getCatId().equals(catId)){
                cartItemRepository.delete(item);
                break;
            }
        }
    }
}
