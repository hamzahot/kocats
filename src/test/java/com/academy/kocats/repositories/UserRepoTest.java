package com.academy.kocats.repositories;


import com.academy.kocats.KocatsApplication;
import com.academy.kocats.entities.ShoppingCart;
import com.academy.kocats.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ActiveProfiles("dev")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KocatsApplication.class)
public class UserRepoTest {


    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldReturnAllUsers(){
        List<User> users = userRepository.findAllUsers();
        assertThat(users).isNotEmpty();
        log.info(users.get(0).getFirstName());

    }

    @Test
    void shouldSaveUser(){
        User user = new User();
        user.setFirstName("Munir");
        user.setLastName("Hot");
        user.setUsername("mujo");
        user.setPassword("mujo123");


        userRepository.save(user);

    }

    @Test
    void shouldUpdateUser(){
        User user = userRepository.findByUId(1);
        log.info(user.getUserId().toString());
        user.setFirstName("Hamzaa");
        user.setLastName("Hot");
        user.setUsername("amarhot22");
        user.setPassword("amkalj2");

        userRepository.save(user);

    }


    @Test
    void shouldRemoveRole(){
        //User user = userRepository.findByUserIdWithPurchase(9);
        //User user = userRepository.findByUserId(9);
//        User user = userRepository.findWithRolesByUsername("marko06");
//        Role role = roleRepository.findByName("Manager");
//
        //user.removeRoleById(2);

        //user.removePurchases();

        userRepository.deleteById(4);
    }



}
