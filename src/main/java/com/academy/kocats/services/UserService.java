package com.academy.kocats.services;


import com.academy.kocats.dto.user.command.UserCreateDTO;
import com.academy.kocats.dto.user.query.UserGetDTO;
import com.academy.kocats.entities.User;
import com.academy.kocats.mappers.UserMapper;
import com.academy.kocats.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public void insert(UserCreateDTO userCreateDTO) {
        User user = userMapper.toEntity(userCreateDTO);
        userRepository.save(user);
    }


    public List<UserGetDTO> getAll() {

        List<User> users = userRepository.findAllUsers();
        List<UserGetDTO> userGetDTOS = new ArrayList<>();

        for(User user : users){
            userGetDTOS.add(userMapper.toGetDTO(user));
        }

        return userGetDTOS;

    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }


    public UserGetDTO getById(Integer id) {

        User user = userRepository.findByUserId(id);
        return userMapper.toGetDTO(user);

    }


//    public UserGetDTO getByIdWp(Integer id) {
//
//        User user = userRepository.findByUserIdWp(id);
//        return userMapper.toGetDTO(user);
//
//    }

    public void update(Integer id, UserCreateDTO userCreateDTO) {

        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found!"));

        user.setFirstName( userCreateDTO.getFirstName() );
        user.setLastName( userCreateDTO.getLastName() );
        user.setEmail( userCreateDTO.getEmail() );
        user.setUsername( userCreateDTO.getUsername() );
        user.setPassword( userCreateDTO.getPassword() );
        user.setPhoneNumber( userCreateDTO.getPhoneNumber() );
        user.setBirthDate( userCreateDTO.getBirthDate() );

        userRepository.save(user);

    }
}
