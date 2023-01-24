package com.academy.kocats.services;


import com.academy.kocats.dto.user.command.UserCreateDTO;
import com.academy.kocats.dto.user.query.UserGetDTO;
import com.academy.kocats.entities.User;
import com.academy.kocats.mappers.UserMapper;
import com.academy.kocats.repositories.UserRepository;
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
}
