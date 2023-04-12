package com.academy.kocats.repositories;


import com.academy.kocats.KocatsApplication;
import com.academy.kocats.dto.role.RoleDTO;
import com.academy.kocats.dto.user.command.UserCreateDTO;
import com.academy.kocats.entities.Role;
import com.academy.kocats.entities.ShoppingCart;
import com.academy.kocats.entities.User;
import com.academy.kocats.mappers.RoleMapper;
import com.academy.kocats.mappers.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ActiveProfiles("dev")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KocatsApplication.class)
public class UserRepoTest {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    void shouldReturnAllUsers(){
        List<User> users = userRepository.findAllUsers();
        assertThat(users).isNotEmpty();
        log.info(users.get(0).getFirstName());

    }

    @Test
    void shouldSaveUser(){
        Role role = new Role();
        role.setRoleId(3);

        User user = userRepository.findWithRolesById(32);
        user.addRole(role);
        


        userRepository.save(user);
    }

    @Test
    void shouldUpdateUser(){

        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setFirstName("Novi");
        userCreateDTO.setLastName("hadalj");
        userCreateDTO.setUsername("haddalj");
        userCreateDTO.setPassword("haldaj");
        userCreateDTO.setEmail("hadalj");
        userCreateDTO.setPhoneNumber("123456789");
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(3);
        Set<RoleDTO> roleDTOS = new HashSet<>();
        roleDTOS.add(roleDTO);
        userCreateDTO.setRoles(roleDTOS);

        User user = userMapper.toEntity(userCreateDTO);

//        Set<Role> roles = roleDTOS.stream().map(roleMapper :: toEntity).collect(Collectors.toSet());
//        user.setRoles(roles);


        log.info(user.getFirstName() + " ");
        for(RoleDTO role : userCreateDTO.getRoles()){
            log.info(role.getRoleId().toString());
        }
        for(Role role : user.getRoles()){
            log.info(role.getRoleId().toString());
        }

//        User user = new User();
//
//        user.setFirstName("Bakir");
//        user.setLastName("bekt");
//        user.setUsername("baksa");
//        user.setPassword("baksa");
//        user.setEmail("baksa@");
//
//        Role role = new Role();
//        role.setRoleId(3);

        //user.addRole(role);

//        Set<Role> set = user.getRoles();
//        set.add(role);
//        user.setRoles(set);

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



    @Test
    void shouldCheckUsername(){
        boolean b = userRepository.existsByUsername("amarhot212342");
        log.info(Boolean.toString(b));
    }

    @Test
    void shouldCheckUsernameAndPassword(){
        boolean b = userRepository.existsByUsernameAndPassword("amarhot22", "amka23lj2");
        log.info(Boolean.toString(b));
    }


    @Test
    void shouldCheckEmail(){
        boolean b = userRepository.existsByEmail("hamzahotdfg74i");
        log.info(Boolean.toString(b));
    }


    @Test
    void shouldGetWithRoles(){
        User user = userRepository.findWithRolesById(43);
        for(Role role : user.getRoles()){
            log.info(role.getName());
        }
    }


}
